package com.stupid.stupidandroid.data.api

import com.stupid.stupidandroid.data.model.RemotePost
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface NetworkService {

    @GET(value = "/api/v1/post/list")
    suspend fun getPostList(
        @Query("lastId") lastId: Int = -1,
        @Query("size") size: Int = 20,
        @Query("memberId") memberId : Long
    ): Response<List<RemotePost>>

    @Multipart
    @POST(value = "/api/v1/post")
    suspend fun createPost(
        @Part image: MultipartBody.Part,
        @Part("post") post: RequestBody,
    )
}
