package com.stupid.stupidandroid.ui.screen.post

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.stupidandroid.usecase.CreatePostUseCase
import com.stupid.stupidandroid.usecase.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

data class PostUiStateSnapshot(
    val first: PostUiModel.First? = null,
    val second: PostUiModel.Second? = null,
    val third: PostUiModel.Third? = null,
    val fourth: PostUiModel.Fourth? = null,
    val fourth2: PostUiModel.Fourth2? = null,
) {
    fun toPost(): Post {
        return Post(
            title = second?.explain!!,
            memberId = 0,
            contentFirst = third?.currentReason!!,
            contentSecond = fourth?.currentReason ?: fourth2?.currentReason!!
        )
    }
}

@HiltViewModel
class PostViewModel @Inject constructor(
    private val createPostUseCase: CreatePostUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<PostUiState> = MutableStateFlow(PostUiState(PostUiModel.First(), false))
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    private var stateSnapshot = PostUiStateSnapshot()

    fun setImageUri(uri: Uri?, file: File?) {
        val uiModel = (uiState.value.postUiModel as? PostUiModel.First) ?: return

        _uiState.value = uiState.value.copy(postUiModel = uiModel.copy(uri = uri, file = file))
    }

    fun setExplain(explain: String) {
        val uiModel = (uiState.value.postUiModel as? PostUiModel.Second) ?: return

        _uiState.value = uiState.value.copy(postUiModel = uiModel.copy(explain = explain))
    }

    fun setReason(reason: String, isPlanA: Boolean) {
        val uiModel = (uiState.value.postUiModel as? PostUiModel.Third) ?: return

        _uiState.value = uiState.value.copy(postUiModel = uiModel.copy(currentReason = reason, isPlanA = isPlanA))
    }

    fun setDoubtReason(reason: String) {
        val uiModel = (uiState.value.postUiModel as? PostUiModel.Fourth) ?: return

        _uiState.value = uiState.value.copy(postUiModel = uiModel.copy(currentReason = reason))
    }

    fun setDoubt2Reason(reason: String) {
        val uiModel = (uiState.value.postUiModel as? PostUiModel.Fourth2) ?: return

        _uiState.value = uiState.value.copy(postUiModel = uiModel.copy(currentReason = reason))
    }

    fun goNextStep() {
        when (val state = uiState.value.postUiModel) {
            is PostUiModel.First -> {
                stateSnapshot = stateSnapshot.copy(first = state)
                _uiState.update {
                    it.copy(postUiModel = PostUiModel.Second(state.requireUri, ""))
                }
            }

            is PostUiModel.Second -> {
                stateSnapshot = stateSnapshot.copy(second = state)
                _uiState.update {
                    it.copy(postUiModel = PostUiModel.Third())
                }
            }

            is PostUiModel.Third -> {
                stateSnapshot = stateSnapshot.copy(third = state)
                _uiState.update {
                    it.copy(
                        postUiModel = if (state.isPlanA) {
                            PostUiModel.Fourth()
                        } else {
                            PostUiModel.Fourth2()
                        }
                    )
                }
            }

            is PostUiModel.Fourth -> {
                stateSnapshot = stateSnapshot.copy(fourth = state)
                _uiState.update {
                    it.copy(postUiModel = PostUiModel.Finish((stateSnapshot.first ?: PostUiModel.First()).requireUri))
                }
            }

            is PostUiModel.Fourth2 -> {
                stateSnapshot = stateSnapshot.copy(fourth2 = state)
                _uiState.update {
                    it.copy(postUiModel = PostUiModel.Finish((stateSnapshot.first ?: PostUiModel.First()).requireUri))
                }
            }

            is PostUiModel.Finish -> {
                viewModelScope.launch {
                    _uiState.update {
                        it.copy(isLoading = true)
                    }

                    createPostUseCase(
                        stateSnapshot.first?.file!!,
                        stateSnapshot.toPost(),
                    )
                }.invokeOnCompletion {
                    _uiState.update {
                        it.copy(isLoading = false)
                    }
                }
            }
        }
    }
}
