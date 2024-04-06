package com.stupid.stupidandroid.ui.design.icon.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.ui.design.icon.IconPack

public val IconPack.IcKakao: ImageVector
    get() {
        if (_icKakao != null) {
            return _icKakao!!
        }
        _icKakao = Builder(name = "IcKakao", defaultWidth = 18.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 18.0f, viewportHeight = 18.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(9.0f, 0.6f)
                    curveTo(4.0292f, 0.6f, 0.0f, 3.7129f, 0.0f, 7.5523f)
                    curveTo(0.0f, 9.94f, 1.5584f, 12.0449f, 3.9315f, 13.2969f)
                    lineTo(2.933f, 16.9445f)
                    curveTo(2.8448f, 17.2668f, 3.2134f, 17.5237f, 3.4965f, 17.3369f)
                    lineTo(7.8733f, 14.4482f)
                    curveTo(8.2427f, 14.4838f, 8.6181f, 14.5046f, 9.0f, 14.5046f)
                    curveTo(13.9705f, 14.5046f, 17.9999f, 11.3918f, 17.9999f, 7.5523f)
                    curveTo(17.9999f, 3.7129f, 13.9705f, 0.6f, 9.0f, 0.6f)
                    close()
                }
            }
        }
        .build()
        return _icKakao!!
    }

private var _icKakao: ImageVector? = null
