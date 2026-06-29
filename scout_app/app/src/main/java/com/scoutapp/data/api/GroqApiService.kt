package com.scoutapp.data.api

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface GroqApiService {
    @POST("chat/completions")
    suspend fun getChatCompletion(
        @Header("Authorization") auth: String,
        @Body request: GroqChatRequest
    ): GroqChatResponse
}

data class GroqChatRequest(
    val model: String,
    val messages: List<GroqMessage>,
    val temperature: Float = 0.7f,
    val max_tokens: Int = 1024
)

data class GroqMessage(
    val role: String,
    val content: String
)

data class GroqChatResponse(
    val choices: List<GroqChoice>
)

data class GroqChoice(
    val message: GroqMessage
)
