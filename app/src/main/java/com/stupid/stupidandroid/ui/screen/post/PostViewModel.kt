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
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

data class PostUiStateSnapshot(
    val first: PostUiState.First? = null,
    val second: PostUiState.Second? = null,
    val third: PostUiState.Third? = null,
    val fourth: PostUiState.Fourth? = null,
    val fourth2: PostUiState.Fourth2? = null,
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
    private val _uiState: MutableStateFlow<PostUiState> = MutableStateFlow(PostUiState.First())
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    private var stateSnapshot = PostUiStateSnapshot()

    fun setImageUri(uri: Uri?, file: File?) {
        val state = (uiState.value as? PostUiState.First) ?: return

        _uiState.value = state.copy(uri = uri, file = file)
    }

    fun setExplain(explain: String) {
        val state = (uiState.value as? PostUiState.Second) ?: return

        _uiState.value = state.copy(explain = explain)
    }

    fun setReason(reason: String, isPlanA: Boolean) {
        val state = (uiState.value as? PostUiState.Third) ?: return

        _uiState.value = state.copy(currentReason = reason, isPlanA = isPlanA)
    }

    fun setDoubtReason(reason: String) {
        val state = (uiState.value as? PostUiState.Fourth) ?: return

        _uiState.value = state.copy(currentReason = reason)
    }

    fun setDoubt2Reason(reason: String) {
        val state = (uiState.value as? PostUiState.Fourth2) ?: return

        _uiState.value = state.copy(currentReason = reason)
    }

    fun goNextStep() {
        when (val state = uiState.value) {
            is PostUiState.First -> {
                stateSnapshot = stateSnapshot.copy(first = state)
                _uiState.value = PostUiState.Second(state.requireUri, "")
            }

            is PostUiState.Second -> {
                stateSnapshot = stateSnapshot.copy(second = state)
                _uiState.value = PostUiState.Third()
            }

            is PostUiState.Third -> {
                stateSnapshot = stateSnapshot.copy(third = state)
                _uiState.value = if (state.isPlanA) {
                    PostUiState.Fourth()
                } else {
                    PostUiState.Fourth2()
                }
            }

            is PostUiState.Fourth -> {
                stateSnapshot = stateSnapshot.copy(fourth = state)
                _uiState.value = PostUiState.Finish((stateSnapshot.first ?: PostUiState.First()).requireUri)
            }

            is PostUiState.Fourth2 -> {
                stateSnapshot = stateSnapshot.copy(fourth2 = state)
                _uiState.value = PostUiState.Finish((stateSnapshot.first ?: PostUiState.First()).requireUri)
            }

            is PostUiState.Finish -> {
                viewModelScope.launch {
                    createPostUseCase(
                        stateSnapshot.first?.file!!,
                        stateSnapshot.toPost(),
                    )
                }
            }
        }
    }
}
