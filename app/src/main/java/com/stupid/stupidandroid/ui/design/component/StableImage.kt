package com.stupid.stupidandroid.ui.design.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


@Composable
fun StableImage (
    @DrawableRes drawableResId: Int,
    description : String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    val painter = painterResource(id = drawableResId)
    Image(
        modifier = modifier,
        painter = painter,
        contentScale = contentScale,
        contentDescription = description
    )
}