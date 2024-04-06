package com.stupid.stupidandroid.ui.theme

import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp

object Typography {
    private val DefaultTextStyle = TextStyle(
        fontFamily = PretendardFamily,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        ),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

    val XxLargeSemiBold36 = DefaultTextStyle.copy(
        fontSize = 36.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 54.sp
    )

    val XxLargeMedium32 = DefaultTextStyle.copy(
        fontSize = 32.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 44.sp
    )

    val XLargeBold28 = DefaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 40.sp
    )

    val XLargeSemiBold28 = DefaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 40.sp
    )

    val XLargeMedium28 = DefaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 44.sp
    )

    val LargeSemiBold26 = DefaultTextStyle.copy(
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 36.sp
    )

    val LargeMedium26 = DefaultTextStyle.copy(
        fontSize = 26.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 36.sp
    )

    val LargeLight26 = DefaultTextStyle.copy(
        fontSize = 26.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 36.sp
    )

    val MediumSemiBold24 = DefaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 36.sp
    )


    val MediumMedium24 = DefaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 34.sp
    )


    val MediumLight24 = DefaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 36.sp
    )

    val MediumSemiBold22 = DefaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp
    )

    val MediumMedium22 = DefaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 32.sp
    )

    val MediumLight22 = DefaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 32.sp
    )

    val MediumThin22 = DefaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.Thin,
        lineHeight = 32.sp
    )

    val SmallMedium20 = DefaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 30.sp
    )

    val SmallRegular20 = DefaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 30.sp
    )

    val SmallLight20 = DefaultTextStyle.copy(
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 30.sp
    )

    val SmallBold18 = DefaultTextStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 28.sp
    )

    val SmallMedium18 = DefaultTextStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 28.sp
    )

    val SmallRegular18 = DefaultTextStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 28.sp
    )

    val SmallLight18 = DefaultTextStyle.copy(
        fontSize = 18.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 28.sp
    )

    val XSmallSemiBold16 = DefaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp
    )

    val XSmallMedium16 = DefaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 26.sp
    )

    val XSmallRegular16 = DefaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 26.sp
    )

    val XSmallLight16 = DefaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 26.sp
    )

    val XSmallSemiBold14 = DefaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 22.sp
    )

    val XSmallMedium14 = DefaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 22.sp
    )

    val XSmallRegular14 = DefaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp
    )

    val XSmallLight14 = DefaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light,
        lineHeight = 22.sp
    )

    val XxSmallBold12 = DefaultTextStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 18.sp
    )

    val XxSmallMedium12 = DefaultTextStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 18.sp
    )

    val XxSmallRegular12 = DefaultTextStyle.copy(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp
    )
}