package com.stupid.stupidandroid.ui.design.icon.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.ui.design.icon.IconPack

public val IconPack.IcBuy: ImageVector
    get() {
        if (_icBuy != null) {
            return _icBuy!!
        }
        _icBuy = Builder(name = "IcBuy", defaultWidth = 70.0.dp, defaultHeight = 140.0.dp,
                viewportWidth = 70.0f, viewportHeight = 140.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = SolidColor(Color(0xFF242424)),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(-1.992f, 8.373f)
                lineTo(0.0f, 1.738f)
                lineTo(1.992f, 8.373f)
                curveTo(4.834f, 17.835f, 17.013f, 20.416f, 23.448f, 12.92f)
                lineTo(27.925f, 7.705f)
                lineTo(27.051f, 14.665f)
                curveTo(25.822f, 24.452f, 35.883f, 31.74f, 44.799f, 27.521f)
                lineTo(51.025f, 24.576f)
                lineTo(47.374f, 30.638f)
                curveTo(42.296f, 39.07f, 48.504f, 49.791f, 58.345f, 49.584f)
                lineTo(65.303f, 49.438f)
                lineTo(59.507f, 53.489f)
                curveTo(51.449f, 59.12f, 52.746f, 71.42f, 61.801f, 75.248f)
                lineTo(68.288f, 77.99f)
                lineTo(61.41f, 79.31f)
                curveTo(51.751f, 81.163f, 47.917f, 92.929f, 54.629f, 100.118f)
                lineTo(59.463f, 105.294f)
                lineTo(52.73f, 103.707f)
                curveTo(43.139f, 101.445f, 34.825f, 110.652f, 38.049f, 119.963f)
                lineTo(40.356f, 126.626f)
                lineTo(34.895f, 122.458f)
                curveTo(27.046f, 116.468f, 15.677f, 121.515f, 14.855f, 131.354f)
                lineTo(14.274f, 138.3f)
                lineTo(10.967f, 132.252f)
                curveTo(6.226f, 123.582f, -6.226f, 123.582f, -10.967f, 132.252f)
                lineTo(-14.274f, 138.3f)
                lineTo(-14.855f, 131.354f)
                curveTo(-15.677f, 121.515f, -27.046f, 116.468f, -34.895f, 122.458f)
                lineTo(-40.356f, 126.626f)
                lineTo(-38.049f, 119.963f)
                curveTo(-34.825f, 110.652f, -43.139f, 101.445f, -52.73f, 103.707f)
                lineTo(-59.463f, 105.294f)
                lineTo(-54.629f, 100.118f)
                curveTo(-47.917f, 92.929f, -51.751f, 81.163f, -61.41f, 79.31f)
                lineTo(-68.288f, 77.99f)
                lineTo(-61.801f, 75.248f)
                curveTo(-52.746f, 71.42f, -51.449f, 59.12f, -59.507f, 53.489f)
                lineTo(-65.303f, 49.438f)
                lineTo(-58.345f, 49.584f)
                curveTo(-48.504f, 49.791f, -42.296f, 39.07f, -47.374f, 30.638f)
                lineTo(-51.025f, 24.576f)
                lineTo(-44.799f, 27.521f)
                curveTo(-35.883f, 31.74f, -25.822f, 24.452f, -27.051f, 14.665f)
                lineTo(-27.925f, 7.705f)
                lineTo(-23.448f, 12.92f)
                curveTo(-17.013f, 20.416f, -4.834f, 17.835f, -1.992f, 8.373f)
                close()
            }
            path(fill = SolidColor(Color(0xFF242424)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.109f, 67.328f)
                curveTo(9.109f, 68.271f, 8.932f, 69.201f, 8.578f, 70.117f)
                curveTo(8.224f, 71.034f, 7.75f, 71.854f, 7.156f, 72.578f)
                curveTo(6.568f, 73.302f, 5.932f, 73.854f, 5.25f, 74.234f)
                lineTo(4.609f, 73.445f)
                curveTo(5.25f, 73.122f, 5.852f, 72.635f, 6.414f, 71.984f)
                curveTo(6.977f, 71.328f, 7.43f, 70.591f, 7.773f, 69.773f)
                curveTo(8.117f, 68.956f, 8.292f, 68.141f, 8.297f, 67.328f)
                verticalLineTo(64.664f)
                horizontalLineTo(9.109f)
                verticalLineTo(67.328f)
                close()
                moveTo(9.258f, 67.328f)
                curveTo(9.258f, 68.104f, 9.43f, 68.885f, 9.773f, 69.672f)
                curveTo(10.117f, 70.453f, 10.57f, 71.154f, 11.133f, 71.773f)
                curveTo(11.695f, 72.388f, 12.292f, 72.854f, 12.922f, 73.172f)
                lineTo(12.313f, 73.969f)
                curveTo(11.625f, 73.599f, 10.987f, 73.068f, 10.398f, 72.375f)
                curveTo(9.81f, 71.682f, 9.339f, 70.896f, 8.984f, 70.016f)
                curveTo(8.63f, 69.13f, 8.456f, 68.234f, 8.461f, 67.328f)
                verticalLineTo(64.664f)
                horizontalLineTo(9.258f)
                verticalLineTo(67.328f)
                close()
                moveTo(15.391f, 77.219f)
                horizontalLineTo(14.398f)
                verticalLineTo(63.43f)
                horizontalLineTo(15.391f)
                verticalLineTo(77.219f)
                close()
                moveTo(17.773f, 69.977f)
                horizontalLineTo(15.148f)
                verticalLineTo(69.117f)
                horizontalLineTo(17.773f)
                verticalLineTo(69.977f)
                close()
                moveTo(29.219f, 77.242f)
                horizontalLineTo(28.227f)
                verticalLineTo(63.43f)
                horizontalLineTo(29.219f)
                verticalLineTo(77.242f)
                close()
                moveTo(31.602f, 69.852f)
                horizontalLineTo(28.977f)
                verticalLineTo(69.008f)
                horizontalLineTo(31.602f)
                verticalLineTo(69.852f)
                close()
                moveTo(20.258f, 73.008f)
                curveTo(21.685f, 73.013f, 22.893f, 72.982f, 23.883f, 72.914f)
                curveTo(24.872f, 72.846f, 25.88f, 72.714f, 26.906f, 72.516f)
                lineTo(27.008f, 73.344f)
                curveTo(25.945f, 73.542f, 24.912f, 73.677f, 23.906f, 73.75f)
                curveTo(22.906f, 73.818f, 21.69f, 73.854f, 20.258f, 73.859f)
                horizontalLineTo(19.18f)
                verticalLineTo(73.008f)
                horizontalLineTo(20.258f)
                close()
                moveTo(25.375f, 69.555f)
                horizontalLineTo(20.156f)
                verticalLineTo(73.367f)
                horizontalLineTo(19.18f)
                verticalLineTo(68.719f)
                horizontalLineTo(24.398f)
                verticalLineTo(65.586f)
                horizontalLineTo(19.141f)
                verticalLineTo(64.758f)
                horizontalLineTo(25.375f)
                verticalLineTo(69.555f)
                close()
            }
        }
        .build()
        return _icBuy!!
    }

private var _icBuy: ImageVector? = null
