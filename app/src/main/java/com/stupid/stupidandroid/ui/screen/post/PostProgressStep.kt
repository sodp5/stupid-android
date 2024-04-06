package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import com.stupid.stupidandroid.R

enum class PostProgressStep(val isShowingStepInProgress: Boolean) {
    First(
        isShowingStepInProgress = true,
    ),
    Second(
        isShowingStepInProgress = true,
    ),
    Third(
        isShowingStepInProgress = true,
    ),
    Fourth(
        isShowingStepInProgress = true,
    ),
    Fourth2(
        isShowingStepInProgress = false,
    ),
    Finished(
        isShowingStepInProgress = false,
    ),
}

fun PostProgressStep.asNumber(): String {
    return when (this) {
        PostProgressStep.First,
        PostProgressStep.Second,
        PostProgressStep.Third,
        PostProgressStep.Fourth -> (ordinal + 1).toString()
        PostProgressStep.Fourth2 -> ordinal.toString()

        PostProgressStep.Finished -> error("$this cannot convert number")

    }
}

@Composable
@ReadOnlyComposable
fun PostProgressStep.asExplain(): String {
    val explainRes = when (this) {
        PostProgressStep.First -> R.string.post_explain_1
        PostProgressStep.Second -> R.string.post_explain_2
        PostProgressStep.Third -> R.string.post_explain_3
        PostProgressStep.Fourth -> R.string.post_explain_4
        PostProgressStep.Fourth2 -> R.string.post_explain_finally_4

        PostProgressStep.Finished -> error("$this cannot convert explain")
    }

    return stringResource(explainRes)
}
