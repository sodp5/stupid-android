package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import com.stupid.stupidandroid.data.model.RemotePost
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class GetPostListUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke(
        lastId: Int = -1,
        size: Int = 20,
        memberId: Long
    ): Flow<List<RemotePost>> = flow {
        try {
            val result = networkService.getPostList(
                lastId = lastId,
                size = size,
                memberId = memberId
            )

            if (result.isSuccessful && result.body() != null) {
                emit(result.body()!!)
            } else {
                throw RuntimeException(result.errorBody()?.string())
            }

        } catch (e: Exception) {
            throw e
        }
    }

}