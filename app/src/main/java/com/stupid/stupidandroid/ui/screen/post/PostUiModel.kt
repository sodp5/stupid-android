package com.stupid.stupidandroid.ui.screen.post

import android.net.Uri
import java.io.File

sealed interface PostUiModel {
    val step: PostProgressStep
    val canNext: Boolean

    data class First(
        val file: File? = null,
        val uri: Uri? = null,
    ) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.First
        override val canNext: Boolean = uri != null

        val requireUri get() = uri ?: error("No image has been selected in this step.")
    }

    data class Second(
        val uri: Uri,
        val explain: String,
    ) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.Second
        override val canNext: Boolean = IntRange(1, 17).contains(explain.length)
    }

    data class Third(
        val currentReason: String? = null,
        val isPlanA: Boolean = false,
    ) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.Third
        override val canNext: Boolean = currentReason?.isNotEmpty() == true
    }

    data class Fourth(val currentReason: String? = null) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.Fourth
        override val canNext: Boolean = currentReason?.isNotEmpty() == true
    }

    data class Fourth2(val currentReason: String? = null) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.Fourth2
        override val canNext: Boolean = currentReason?.isNotEmpty() == true
    }

    data class Finish(val uri: Uri) : PostUiModel {
        override val step: PostProgressStep = PostProgressStep.Finished
        override val canNext: Boolean = true
    }
}
