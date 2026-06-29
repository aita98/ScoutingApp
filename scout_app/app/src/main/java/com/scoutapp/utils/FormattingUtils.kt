package com.scoutapp.utils

import java.util.Locale

fun formatMarketValue(value: Double?): String {
    if (value == null || value == 0.0) return "N/A"
    
    // Gestione scala (se il valore è < 1000, assumiamo sia già in milioni)
    val normalized = if (value > 0 && value < 1000) value * 1_000_000.0 else value
    
    return if (normalized >= 1_000_000) {
        String.format(Locale.US, "%.1fM€", normalized / 1_000_000.0)
    } else if (normalized >= 1_000) {
        String.format(Locale.US, "%.0fK€", normalized / 1_000.0)
    } else {
        String.format(Locale.US, "%.0f€", normalized)
    }
}

/**
 * Universal formatter for any market value type (String, Number, etc.)
 * Handles scientific notation, suffixes, and raw large numbers.
 */
fun formatAnyMarketValue(value: Any?): String {
    if (value == null) return "N/A"
    
    val rawString = value.toString().trim()
    if (rawString.isEmpty() || rawString.lowercase() == "n/a" || rawString == "0") return "N/A"
    
    val cleanStr = rawString.replace("€", "").lowercase()
    val hasM = cleanStr.contains("m")
    val hasK = cleanStr.contains("k")
    
    val numericPart = cleanStr.replace("m", "").replace("k", "").replace(" ", "")
        .replace(Regex("[^0-9.eE\\-]"), "")
    
    val d = numericPart.toDoubleOrNull() ?: return rawString
    
    // Normalizziamo in valore assoluto (Euro)
    val absoluteValue = when {
        hasM -> if (d > 1000) d else d * 1_000_000.0
        hasK -> if (d > 1000000) d else d * 1_000.0
        else -> if (d > 0 && d < 1000) d * 1_000_000.0 else d
    }
    
    return if (absoluteValue >= 1_000_000) {
        String.format(Locale.US, "%.1fM€", absoluteValue / 1_000_000.0)
    } else if (absoluteValue >= 1_000) {
        String.format(Locale.US, "%.0fK€", absoluteValue / 1_000.0)
    } else {
        String.format(Locale.US, "%.0f€", absoluteValue)
    }
}
