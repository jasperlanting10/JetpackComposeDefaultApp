/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.myapplication.theme

import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.composer
import androidx.compose.unaryPlus
import androidx.ui.core.Px
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.sp
import androidx.ui.engine.geometry.Shape
import androidx.ui.foundation.ColoredRect
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vectorgraphics.Brush
import androidx.ui.graphics.vectorgraphics.ColorStop
import androidx.ui.graphics.vectorgraphics.LinearGradient
import androidx.ui.layout.*
import androidx.ui.layout.Container
import androidx.ui.material.surface.Card
import com.example.myapplication.control.Category
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.graphics.vectorgraphics.VerticalGradient
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight

// TODO: This is not integrated with the theme
internal val cardInternalColor = Color.LightGray

val heinekenWhite = Color(255,255,255)
val heinekenLightGreen = Color(0,130,0)
val heinekenDarkGreen = Color(32,85,39)
val heinekenRed = Color(255,43,0)
val heinekenSilver = Color(195,195,195)


@Composable
fun HeinekenTheme(children: @Composable() () -> Unit) {
    val colors = MaterialColors(
        primary = heinekenWhite,
        secondary = heinekenLightGreen,
        secondaryVariant = heinekenDarkGreen,
        error= heinekenRed,
        surface = heinekenSilver
//        , onBackground = heinekenSilver
    )

    val typography = MaterialTypography(
        h1 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w100,
            fontSize = 96.sp),
        h2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w100,
            fontSize = 60.sp),
        h3 = TextStyle(fontFamily = FontFamily("Eczar"),
            fontWeight = FontWeight.w500,
            fontSize = 48.sp),
        h4 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w700,
            color = Color.White,
            fontSize = 34.sp),
        h5 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w700,
            color = Color.Black,
            fontSize = 24.sp),
        h6 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w700,
            color = Color.Black,
            fontSize = 20.sp),
        subtitle1 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w700,
            color = Color.Black,
            fontSize = 16.sp),
        subtitle2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w500,
            fontSize = 14.sp),
        body1 = TextStyle(fontFamily = FontFamily("Eczar"),
            fontWeight = FontWeight.w700,
            color = Color.White,
            fontSize = 18.sp),
        body2 = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w200,
            color = Color.White,
            fontSize = 16.sp),
        button = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w800,
            fontSize = 14.sp),
        caption = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w500,
            fontSize = 12.sp),
        overline = TextStyle(fontFamily = FontFamily("RobotoCondensed"),
            fontWeight = FontWeight.w500,
            fontSize = 10.sp)
    )

    MaterialTheme (colors = colors, typography = typography){
        children()
    }
}



