package com.scoutapp.utils

object CompetitionDecoder {
    private val competitionMap = mapOf(
        "IT1" to "Serie A",
        "IT2" to "Serie B",
        "CIT" to "Coppa Italia",
        "SIT" to "Supercoppa Italiana",
        "GB1" to "Premier League",
        "GB2" to "Championship",
        "FAC" to "FA Cup",
        "EFL" to "EFL Cup",
        "ES1" to "LaLiga",
        "ES2" to "LaLiga 2",
        "CDR" to "Copa del Rey",
        "L1" to "Bundesliga",
        "L2" to "2. Bundesliga",
        "DFB" to "DFB-Pokal",
        "FR1" to "Ligue 1",
        "FR2" to "Ligue 2",
        "CDF" to "Coupe de France",
        "NL1" to "Eredivisie",
        "BE1" to "Jupiler Pro League",
        "PO1" to "Liga Portugal",
        "TR1" to "Süper Lig",
        "GR1" to "Super League 1",
        "RU1" to "Premier Liga",
        "UKR1" to "Premier Liga (UA)",
        "CL" to "Champions League",
        "EL" to "Europa League",
        "ECL" to "Conference League",
        "USC" to "UEFA Super Cup",
        "KLUB" to "FIFA Club World Cup",
        "WM" to "World Cup",
        "EM" to "Euro",
        "UNL" to "Nations League"
    )

    fun decode(id: String?): String {
        if (id == null) return "Unknown"
        return competitionMap[id] ?: id
    }
}
