# Professional Football Scouting System

Sistema completo di scouting calcistico con Backend Spring Boot e App Android Jetpack Compose.

## Struttura del Progetto
- `/backend`: Spring Boot 3.2, Java 21, PostgreSQL.
- `/scout_app`: App Android Native (Kotlin, Compose, Hilt, Retrofit).

## Funzionalità Principali
- **Discovery Engine**: Algoritmi per Talent Score e Hidden Gems.
- **AI Assistant**: Analisi profili tramite linguaggio naturale.
- **Comparison System**: Confronto side-by-side con Radar Chart personalizzati.
- **Scout Feed**: Notifiche in tempo reale su esplosioni di talenti e trasferimenti.
- **Offline Mode**: Watchlist salvata localmente con Room.

## Configurazione Backend
1. **Database**: Assicurati di avere PostgreSQL attivo e un database chiamato `scout_db`.
2. **API Keys**: Inserisci la tua API Key di [Football-Data.org](https://www.football-data.org/) in `backend/src/main/resources/application.yml`.
   - Il sistema utilizza anche **TheSportsDB** (chiave demo inclusa) per le immagini.
3. **Avvio**: Apri la cartella `backend` in **Android Studio** (che supporta anche progetti Java/Maven) o esegui `mvn spring-boot:run` dal terminale.

## Build App Android
1. Apri la cartella `scout_app` in Android Studio.
2. **IP Backend**: Modifica `NetworkModule.kt` inserendo l'indirizzo IP locale del tuo PC (es. `192.168.x.x`) se testi su telefono fisico, o `10.0.2.2` per l'emulatore.
3. **Generazione APK**: Vai su `Build -> Build Bundle(s) / APK(s) -> Build APK(s)`.
4. **Installazione**: Copia il file `.apk` generato sul tuo telefono e installalo.

---
Sviluppato per Scouting Professionale.
