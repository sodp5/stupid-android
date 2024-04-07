package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import com.stupid.stupidandroid.data.model.RemoteMyPage
import com.stupid.stupidandroid.data.model.RemoteMyPageItem
import com.stupid.stupidandroid.util.LoginManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.RuntimeException
import javax.inject.Inject

class GetMyPagePostItemListUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    operator fun invoke(
        memberId : Long,
        isPostItem : Boolean = true
    ): Flow<List<RemoteMyPageItem>> = flow {
        try {
            val result = if(isPostItem) networkService.getMypagePostItemList(
                memberId = LoginManager.memberId.toLong()
            ) else networkService.getMypageVotedItemList(LoginManager.memberId.toLong())
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