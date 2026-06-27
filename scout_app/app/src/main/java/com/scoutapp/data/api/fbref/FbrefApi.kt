package com.scoutapp.data.api.fbref

import retrofit2.http.GET
import retrofit2.http.Path

interface FbrefApi {
    @GET("resolve/{name}")
    suspend fun resolvePlayer(
        @Path("name") name: String
    ): FbrefResolveResponseDto

    @GET("stats/{fbref_id}/{slug}")
    suspend fun getStats(
        @Path("fbref_id") fbrefId: String,
        @Path("slug") slug: String
    ): FbrefStatsResponseDto
}
