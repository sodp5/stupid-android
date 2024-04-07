package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import com.stupid.stupidandroid.data.model.RemoteMyPage
import com.stupid.stupidandroid.util.LoginManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMyPageInfoUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke(
        memberId : Long
    ): Flow<RemoteMyPage> = flow {
        try {
            val result = networkService.getMypageInfo(
                memberId = LoginManager.memberId.toLong()
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