package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import com.stupid.stupidandroid.data.model.RemoteUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterKakaoTokenUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke(
        token: String
    ): Flow<RemoteUser> = flow {
        try {
            val result = networkService.registerKakaoToken(
                token = token
            )
            if (result.isSuccessful && result.body() != null) {
                emit(result.body()!!)
            } else {
                throw RuntimeException(result.errorBody()?.toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }
}
