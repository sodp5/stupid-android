package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class RegisterKakaoTokenUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke(
        token : String
    ): Flow<Unit> = flow {
        try {
            val result = networkService.registerKakaoToken(
                token = token
            )
            if(result.isSuccessful){
                emit(Unit)
            }else {
                throw RuntimeException(result.errorBody()?.toString())
            }
        }catch (e: Exception){
            throw e
        }
    }
}