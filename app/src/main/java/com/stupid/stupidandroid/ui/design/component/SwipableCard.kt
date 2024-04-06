package com.stupid.stupidandroid.ui.design.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun SwipableCard(
    swipeEnabled: Boolean,
    modifier: Modifier = Modifier,
    onSwipeLeft: () -> Unit = {},
    onSwipeRight: () -> Unit = {},
    swipeThreshold: Float = 500f,
    sensitivityFactor: Float = 4f,
    content: @Composable () -> Unit
) {
    var offset by remember { mutableStateOf(0f) }
    var dismissRight by remember { mutableStateOf(false) }
    var dismissLeft by remember { mutableStateOf(false) }
    val density = LocalDensity.current.density

    LaunchedEffect(dismissRight) {
        if (dismissRight) {
            delay(100)
            onSwipeRight.invoke()
            dismissRight = false
        }
    }

    LaunchedEffect(dismissLeft) {
        if (dismissLeft) {
            delay(100)
            onSwipeLeft.invoke()
            dismissLeft = false
        }
    }

    Box(modifier = modifier
        .offset { IntOffset(offset.roundToInt(), 0) }
        .then(
            if (swipeEnabled) {
                Modifier.pointerInput(Unit) {
                    detectHorizontalDragGestures(onDragEnd = {
                        offset = 0f
                    }) { change, dragAmount ->

                        offset += (dragAmount / density) * sensitivityFactor
                        when {
                            offset > swipeThreshold -> {
                                for(i in 0..100){
                                    offset += 0.5f
                                }
                                dismissRight = true
                            }

                            offset < -swipeThreshold -> {
                                for(i in 0..100){
                                    offset -= 0.5f
                                }
                                dismissLeft = true
                            }
                        }
                        if (change.positionChange() != Offset.Zero) change.consume()
                    }
                }
            } else {
                Modifier
            }
        )
        .graphicsLayer(
            alpha = 10f - animateFloatAsState(if (dismissRight) 1f else 0f).value,
            rotationZ = animateFloatAsState(offset / 50).value
        )) {
        content()
    }
}
