package com.stupid.stupidandroid.ui.design.icon

import androidx.compose.ui.graphics.vector.ImageVector
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcHomeSelected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcHomeUnselected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcPostSelected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcPostUnselected
import kotlin.collections.List as ____KtList

public object IconPack

private var __Icons: ____KtList<ImageVector>? = null

public val IconPack.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons = listOf(IcHomeSelected, IcPostUnselected,
      IcHomeUnselected, IcPostSelected)
    return __Icons!!
  }

