package com.scoutapp.data.model

data class SyncStatus(
    val syncing: Boolean,
    val progress: Int,
    val message: String
)
