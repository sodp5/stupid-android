package com.stupid.stupidandroid.ui.screen.post

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<PostUiState> = MutableStateFlow(PostUiState.First())
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()

    fun setImageUri(uri: Uri?) {
        val state = (uiState.value as? PostUiState.First) ?: return

        _uiState.value = state.copy(uri = uri)
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
        _uiState.value = when (val state = uiState.value) {
            is PostUiState.First -> PostUiState.Second(state.requireUri, "")
            is PostUiState.Second -> PostUiState.Third()
            is PostUiState.Third -> if (state.isPlanA) {
                PostUiState.Fourth()
            } else {
                PostUiState.Fourth2()
            }

            is PostUiState.Fourth,
            is PostUiState.Fourth2 -> PostUiState.First()
        }
    }
}
