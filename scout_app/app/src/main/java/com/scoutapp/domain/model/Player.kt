package com.scoutapp.domain.model

data class Player(
    val id: Int,
    val name: String,
    val slug: String,
    val nationality: String,
    val position: String,
    val team: String,
    val age: Int
)
