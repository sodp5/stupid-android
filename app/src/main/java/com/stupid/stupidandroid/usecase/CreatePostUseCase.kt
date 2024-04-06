package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

@Serializable
data class Post(
    val title: String,
    val memberId: Long,
    val contentFirst: String,
    val contentSecond: String,
)

class CreatePostUseCase @Inject constructor(
    private val networkService: NetworkService,
) {
    suspend operator fun invoke(file: File, post: Post) {
        val requestBody: RequestBody = file.asRequestBody("image/*".toMediaType())
        val part: MultipartBody.Part = MultipartBody.Part.createFormData("image", file.name, requestBody)

        val json = Json.encodeToString(post).toRequestBody("application/json".toMediaType())

        networkService.createPost(part, json)
    }
}
