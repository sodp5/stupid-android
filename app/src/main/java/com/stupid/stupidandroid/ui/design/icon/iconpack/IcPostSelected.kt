package com.stupid.stupidandroid.ui.design.icon.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.ui.design.icon.IconPack

public val IconPack.IcPostSelected: ImageVector
    get() {
        if (com.stupid.stupidandroid.ui.design.icon.iconpack._icPostSelected != null) {
            return com.stupid.stupidandroid.ui.design.icon.iconpack._icPostSelected!!
        }
        com.stupid.stupidandroid.ui.design.icon.iconpack._icPostSelected = Builder(name = "IcPostSelected", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF242424)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(9.2426f, 18.9964f)
                horizontalLineTo(21.0f)
                verticalLineTo(20.9964f)
                horizontalLineTo(3.0f)
                verticalLineTo(16.7538f)
                lineTo(12.8995f, 6.8543f)
                lineTo(17.1421f, 11.0969f)
                lineTo(9.2426f, 18.9964f)
                close()
                moveTo(14.3137f, 5.4401f)
                lineTo(16.435f, 3.3188f)
                curveTo(16.8256f, 2.9283f, 17.4587f, 2.9283f, 17.8492f, 3.3188f)
                lineTo(20.6777f, 6.1472f)
                curveTo(21.0682f, 6.5377f, 21.0682f, 7.1709f, 20.6777f, 7.5614f)
                lineTo(18.5563f, 9.6827f)
                lineTo(14.3137f, 5.4401f)
                close()
            }
        }
        .build()
        return com.stupid.stupidandroid.ui.design.icon.iconpack._icPostSelected!!
    }

private var _icPostSelected: ImageVector? = null
