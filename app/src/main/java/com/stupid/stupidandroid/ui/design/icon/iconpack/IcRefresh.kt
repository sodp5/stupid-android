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

public val IconPack.IcRefresh: ImageVector
    get() {
        if (_icRefresh != null) {
            return _icRefresh!!
        }
        _icRefresh = Builder(name = "IcRefresh", defaultWidth = 18.0.dp, defaultHeight = 18.0.dp,
                viewportWidth = 18.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0xFF607864)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0969f, 3.3245f)
                curveTo(5.4117f, 2.1877f, 7.1255f, 1.5f, 9.0f, 1.5f)
                curveTo(13.1421f, 1.5f, 16.5f, 4.8579f, 16.5f, 9.0f)
                curveTo(16.5f, 10.6021f, 15.9976f, 12.0869f, 15.1419f, 13.3055f)
                lineTo(12.75f, 9.0f)
                horizontalLineTo(15.0f)
                curveTo(15.0f, 5.6863f, 12.3137f, 3.0f, 9.0f, 3.0f)
                curveTo(7.3874f, 3.0f, 5.9233f, 3.6362f, 4.8452f, 4.6713f)
                lineTo(4.0969f, 3.3245f)
                close()
                moveTo(13.903f, 14.6756f)
                curveTo(12.5883f, 15.8123f, 10.8745f, 16.5f, 9.0f, 16.5f)
                curveTo(4.8579f, 16.5f, 1.5f, 13.1421f, 1.5f, 9.0f)
                curveTo(1.5f, 7.3979f, 2.0023f, 5.9131f, 2.8581f, 4.6946f)
                lineTo(5.25f, 9.0f)
                horizontalLineTo(3.0f)
                curveTo(3.0f, 12.3137f, 5.6863f, 15.0f, 9.0f, 15.0f)
                curveTo(10.6126f, 15.0f, 12.0767f, 14.3638f, 13.1549f, 13.3287f)
                lineTo(13.903f, 14.6756f)
                close()
            }
        }
        .build()
        return _icRefresh!!
    }

private var _icRefresh: ImageVector? = null
