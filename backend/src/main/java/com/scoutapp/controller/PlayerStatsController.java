package com.scoutapp.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/fbref")
public class PlayerStatsController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/stats/combined/{tmId}/{fbrefId}/{slug}")
    public ResponseEntity<?> getCombinedStats(
            @PathVariable String tmId,
            @PathVariable String fbrefId,
            @PathVariable String slug) {

        System.out.println("\n==================================================");
        System.out.println("[HYBRID STATS] Avvio fusione dati per: " + slug);
        System.out.println("[HYBRID STATS] IDs ricevuti -> TM: " + tmId + " | FBref: " + fbrefId);
        System.out.println("==================================================");

        // Mappa finale con valori di fallback sicuri per Android
        Map<String, Object> stats = new HashMap<>();
        stats.put("season", "24/25");
        stats.put("minutes", 0);
        stats.put("goals", 0);
        stats.put("assists", 0);
        stats.put("apps", 0);
        stats.put("xG", 0.0);
        stats.put("xA", 0.0);
        stats.put("key_passes", 0);
        stats.put("progressive_passes", 0);
        stats.put("progressive_carries", 0);
        stats.put("pressures", 0);

        // =========================================================================
        // STEP 1: RACCOLTA DATI STANDARD DA TRANSFERMARKT (LIVE)
        // =========================================================================
        String tmUrl = "https://www.transfermarkt.com/player/leistungsdaten/spieler/" + tmId;
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

        try {
            System.out.println("[TM FETCH] Richiesta live a Transfermarkt: " + tmUrl);
            Document doc = Jsoup.connect(tmUrl).userAgent(userAgent).timeout(10000).get();
            
            // Cerchiamo il box dei dati di performance totali della stagione
            Element table = doc.selectFirst("table.items");
            if (table != null) {
                Element tfoot = table.selectFirst("tfoot");
                if (tfoot != null) {
                    Elements cells = tfoot.select("tr td");
                    if (cells.size() >= 4) {
                        // Pulizia dei dati (TM usa il trattino '-' se il dato è zero)
                        String mpText = cells.get(1).text().trim().replace("-", "0").replace(".", "");
                        String gText = cells.get(2).text().trim().replace("-", "0").replace(".", "");
                        String aText = cells.get(3).text().trim().replace("-", "0").replace(".", "");

                        stats.put("apps", Integer.parseInt(mpText.isEmpty() ? "0" : mpText));
                        stats.put("goals", Integer.parseInt(gText.isEmpty() ? "0" : gText));
                        stats.put("assists", Integer.parseInt(aText.isEmpty() ? "0" : aText));
                        
                        System.out.println("[TM FETCH] SUCCESS! Presenze: " + stats.get("apps") + 
                                           " | Gol: " + stats.get("goals") + " | Assist: " + stats.get("assists"));
                    }
                }
            } else {
                System.out.println("[TM FETCH] ATTENZIONE: Tabella '.items' non trovata. Controllo struttura.");
            }
        } catch (Exception e) {
            System.out.println("[TM FETCH] ERRORE durante la chiamata a Transfermarkt: " + e.getMessage());
        }

        // =========================================================================
        // STEP 2: RACCOLTA DATI AVANZATI DA PROXY / WAYBACK FBREF
        // =========================================================================
        // Qui interroghiamo il tuo proxy Django locale per evitare blocchi Cloudflare
        String djangoProxyUrl = "http://127.0.0.1:9100/fbref/stats/" + fbrefId + "/" + slug;
        
        try {
            System.out.println("[FBREF FETCH] Richiesta dati avanzati al proxy Django: " + djangoProxyUrl);
            
            // Usiamo Jsoup per leggere il JSON emesso da Django
            String jsonResponse = Jsoup.connect(djangoProxyUrl).ignoreContentType(true).timeout(10000).execute().body();
            
            Map<String, Object> map = objectMapper.readValue(jsonResponse, Map.class);
            if (map.containsKey("stats")) {
                Map<String, Object> fbrefStats = (Map<String, Object>) map.get("stats");
                
                // Uniamo i dati avanzati (xG, xA, passaggi chiave, ecc.)
                if (fbrefStats.containsKey("xG")) stats.put("xG", fbrefStats.get("xG"));
                if (fbrefStats.containsKey("xA")) stats.put("xA", fbrefStats.get("xA"));
                if (fbrefStats.containsKey("key_passes")) stats.put("key_passes", fbrefStats.get("key_passes"));
                if (fbrefStats.containsKey("progressive_passes")) stats.put("progressive_passes", fbrefStats.get("progressive_passes"));
                if (fbrefStats.containsKey("progressive_carries")) stats.put("progressive_carries", fbrefStats.get("progressive_carries"));
                if (fbrefStats.containsKey("pressures")) stats.put("pressures", fbrefStats.get("pressures"));
                if (fbrefStats.containsKey("minutes")) stats.put("minutes", fbrefStats.get("minutes"));
                if (fbrefStats.containsKey("season")) stats.put("season", fbrefStats.get("season"));
            }
            
            System.out.println("[FBREF FETCH] SUCCESS! Dati avanzati uniti.");
            
        } catch (Exception e) {
            System.out.println("[FBREF FETCH] ERRORE durante il recupero da FBref Proxy: " + e.getMessage());
        }

        // Risposta finale strutturata per Android Studio
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("player_id", fbrefId);
        responseBody.put("transfermarkt_id", tmId);
        responseBody.put("stats", stats);

        System.out.println("[HYBRID STATS] Risposta inviata ad Android con successo.\n");
        return ResponseEntity.ok(responseBody);
    }
}
