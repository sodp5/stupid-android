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

public val IconPack.IcPostUnselected: ImageVector
    get() {
        if (com.stupid.stupidandroid.ui.design.icon.iconpack._icPostUnselected != null) {
            return com.stupid.stupidandroid.ui.design.icon.iconpack._icPostUnselected!!
        }
        com.stupid.stupidandroid.ui.design.icon.iconpack._icPostUnselected = Builder(name = "IcPostUnselected", defaultWidth = 24.0.dp, defaultHeight
                = 24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF989BA2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.9999f, 18.89f)
                horizontalLineTo(6.4142f)
                lineTo(15.7278f, 9.5763f)
                lineTo(14.3136f, 8.1621f)
                lineTo(4.9999f, 17.4758f)
                verticalLineTo(18.89f)
                close()
                moveTo(20.9999f, 20.89f)
                horizontalLineTo(2.9999f)
                verticalLineTo(16.6474f)
                lineTo(16.4349f, 3.2123f)
                curveTo(16.8255f, 2.8218f, 17.4586f, 2.8218f, 17.8491f, 3.2123f)
                lineTo(20.6776f, 6.0408f)
                curveTo(21.0681f, 6.4313f, 21.0681f, 7.0644f, 20.6776f, 7.455f)
                lineTo(9.2426f, 18.89f)
                horizontalLineTo(20.9999f)
                verticalLineTo(20.89f)
                close()
                moveTo(15.7278f, 6.7479f)
                lineTo(17.142f, 8.1621f)
                lineTo(18.5562f, 6.7479f)
                lineTo(17.142f, 5.3337f)
                lineTo(15.7278f, 6.7479f)
                close()
            }
        }
        .build()
        return com.stupid.stupidandroid.ui.design.icon.iconpack._icPostUnselected!!
    }

private var _icPostUnselected: ImageVector? = null
