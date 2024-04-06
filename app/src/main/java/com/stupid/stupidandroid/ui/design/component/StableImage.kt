package com.stupid.stupidandroid.ui.design.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource


@Composable
fun StableImage (
    modifier: Modifier = Modifier,
    @DrawableRes drawableResId: Int,
    description : String?,
) {
    val painter = painterResource(id = drawableResId)
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = description
    )
}