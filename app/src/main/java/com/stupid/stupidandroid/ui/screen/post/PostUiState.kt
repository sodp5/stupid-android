package com.stupid.stupidandroid.ui.screen.post

import android.net.Uri

sealed interface PostUiState {
    val step: PostProgressStep
    val canNext: Boolean

    data class First(val uri: Uri? = null) : PostUiState {
        override val step: PostProgressStep = PostProgressStep.First
        override val canNext: Boolean = uri != null

        val requireUri get() = uri ?: error("No image has been selected in this step.")
    }

    data class Second(
        val uri: Uri,
        val explain: String,
    ) : PostUiState {
        override val step: PostProgressStep = PostProgressStep.Second
        override val canNext: Boolean = IntRange(1, 17).contains(explain.length)
    }
}
