package com.stupid.stupidandroid.data.api

import com.stupid.stupidandroid.data.model.RemoteMyPage
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

    @GET(value = "/api/v1/oauth/kakao/login/app")
    suspend fun registerKakaoToken(
        @Query("token") token : String
    ) : Response<Unit>

    @Multipart
    @POST(value = "/api/v1/post")
    suspend fun createPost(
        @Part image: MultipartBody.Part,
        @Part("post") post: RequestBody,
    )

    @POST(value = "/api/v1/vote")
    suspend fun vote(
        @Query("memberId") memberId: Long,
        @Query("postId") postId: Long,
        @Query("isAgreed") isAgreed: Boolean,
    )

    @GET(value = "/api/v1/mypage")
    suspend fun getMypageInfo(
        @Query("memberId") memberId : Long
    ) : Response<RemoteMyPage>

}
