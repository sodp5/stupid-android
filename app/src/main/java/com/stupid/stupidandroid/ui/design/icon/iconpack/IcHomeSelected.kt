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

public val IconPack.IcHomeSelected: ImageVector
    get() {
        if (_icHomeSelected != null) {
            return _icHomeSelected!!
        }
        _icHomeSelected = Builder(name = "IcHomeSelected", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF242424)), stroke = null, fillAlpha = 0.8f, strokeAlpha
                    = 0.8f, strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(19.9999f, 20.0001f)
                curveTo(19.9999f, 20.5524f, 19.5522f, 21.0001f, 18.9999f, 21.0001f)
                horizontalLineTo(4.9999f)
                curveTo(4.4477f, 21.0001f, 3.9999f, 20.5524f, 3.9999f, 20.0001f)
                verticalLineTo(11.0001f)
                horizontalLineTo(0.9999f)
                lineTo(11.3272f, 1.6116f)
                curveTo(11.7086f, 1.2649f, 12.2912f, 1.2649f, 12.6726f, 1.6116f)
                lineTo(22.9999f, 11.0001f)
                horizontalLineTo(19.9999f)
                verticalLineTo(20.0001f)
                close()
            }
        }
        .build()
        return _icHomeSelected!!
    }

private var _icHomeSelected: ImageVector? = null
