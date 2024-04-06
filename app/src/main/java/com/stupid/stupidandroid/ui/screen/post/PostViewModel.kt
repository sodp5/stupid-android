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

    fun goNextStep() {
        _uiState.value = when (val state = uiState.value) {
            is PostUiState.First -> PostUiState.Second(state.requireUri, "")
            is PostUiState.Second -> PostUiState.Second(state.uri, "")
        }
    }
}
