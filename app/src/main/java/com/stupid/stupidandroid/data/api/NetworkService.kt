package com.stupid.stupidandroid.data.api

import com.stupid.stupidandroid.data.model.RemotePost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET(value = "/api/v1/post/list")
    suspend fun getPostList(
        @Query("lastId") lastId: Int = -1,
        @Query("size") size: Int = 20,
        @Query("memberId") memberId : Long
    ): Response<List<RemotePost>>

    @GET(value = "/oauth/kakao/login/app")
    suspend fun registerKakaoToken(
        @Query("token") token : String
    ) : Response<Unit>
}