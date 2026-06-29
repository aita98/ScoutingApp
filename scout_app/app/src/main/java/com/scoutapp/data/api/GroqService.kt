package com.scoutapp.data.api

import com.scoutapp.data.model.AIScoutResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GroqService @Inject constructor(
    private val groqApiService: GroqApiService
) {
    private val apiKey = "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"
    private val model = "llama-3.3-70b-versatile"

    private val systemPrompt = """
        Sei un assistente professionista per l'osservazione calcistica (Football Scout).
        Il tuo compito è fornire consigli diretti, tecnici e pertinenti alle richieste dell'osservatore.
        Analizza i profili dei giocatori, suggerisci gemme nascoste, valuta il potenziale e il fit tattico.
        Usa un linguaggio tecnico (es. 'half-space', 'progressive carries', 'underlapping runs').
        Sii conciso ma esaustivo. 
        
        Rispondi sempre in formato strutturato se possibile, separando il 'Report Tecnico' dai 'Consigli Strategici'.
    """.trimIndent()

    suspend fun generateScoutingReport(query: String): AIScoutResponse {
        android.util.Log.d("GROQ_SERVICE", "[REQUEST] Starting scouting report generation for: $query")
        
        return try {
            val request = GroqChatRequest(
                model = model,
                messages = listOf(
                    GroqMessage("system", systemPrompt),
                    GroqMessage("user", "Richiesta dell'osservatore: $query")
                )
            )
            
            val response = groqApiService.getChatCompletion("Bearer $apiKey", request)
            val text = response.choices.firstOrNull()?.message?.content 
                ?: "L'AI non ha generato alcuna risposta."
            
            android.util.Log.d("GROQ_SERVICE", "[RESPONSE] Received ${text.length} characters")

            val parts = text.split("Consigli Strategici", ignoreCase = true)
            val report = parts[0].replace("Report Tecnico", "", ignoreCase = true).trim()
            val recommendations = if (parts.size > 1) parts[1].trim() else "Continua a monitorare il mercato per ulteriori opportunità."

            AIScoutResponse(
                scoutingReport = report,
                similarPlayers = emptyList(),
                similarityScore = 100,
                recommendations = recommendations
            )
        } catch (e: Exception) {
            android.util.Log.e("GROQ_SERVICE", "[ERROR] failed to generate content: ${e.message}", e)
            throw e
        }
    }
}
