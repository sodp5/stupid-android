package com.stupid.stupidandroid.usecase

import com.stupid.stupidandroid.data.api.NetworkService
import javax.inject.Inject

class VoteUseCase @Inject constructor(
    private val networkService: NetworkService
) {
    suspend operator fun invoke(
        postId: Long,
        isAgreed: Boolean,
    ) {
        networkService.vote(
            memberId = 1001,
            postId = postId,
            isAgreed = isAgreed,
        )
    }
}
