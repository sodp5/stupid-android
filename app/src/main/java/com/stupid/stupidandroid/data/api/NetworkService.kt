package com.stupid.stupidandroid.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET(value = "/")
    suspend fun getPostList(
        @Query("teamId") teamId: Int = 2,
        @Query("season") season: String
    ): Response<Unit>
}