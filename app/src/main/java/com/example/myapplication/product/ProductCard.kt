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

package com.example.myapplication.product

import android.content.Intent
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.composer
import androidx.compose.unaryPlus
import androidx.ui.core.*
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
import androidx.ui.foundation.shape.corner.CornerSizes
import androidx.ui.foundation.shape.corner.PxCornerSizes
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.vectorgraphics.VerticalGradient
import androidx.ui.material.*
import androidx.ui.painting.Canvas
import androidx.ui.painting.Paint
import androidx.ui.painting.imageFromResource
import com.example.myapplication.MainActivity
import com.example.myapplication.control.Product


@Composable
fun ProductViewCard(product: Product, onClick: () -> Unit) {
    Card(color = +themeColor { surface }) {
        //card can only hold one child, card is part of the surface class which defines this
        Column {
            Padding(12.dp) {
                Container(height = 240.dp, expanded = true) {
                    DrawShape(RectangleShape, Color.White)
                    Align(Alignment.BottomRight) {
                        Padding(12.dp) {
                            Card(
                                color = Color(0.41f, 0.41f, 0.41f, 0.3f),
                                shape = RoundedCornerShape(
                                    corners = CornerSizes(
                                        30.dp,
                                        30.dp,
                                        30.dp,
                                        30.dp
                                    )
                                )
                            ) {
                                //two times padding because I want the price widget to be 12.dp from the bottom corner
                                Padding(top = 12.dp, bottom = 12.dp, right = 12.dp, left = 12.dp) {
                                    Text(
                                        text = product.price.toString(),
                                        style = +themeTextStyle { body1 })
                                }
                            }
                        }
                    }
                }

            }
            Row(mainAxisAlignment = MainAxisAlignment.Center, mainAxisSize = FlexSize.Max) {
                Text(text = product.name, style = +themeTextStyle { h6 })
            }

        }
    }
}

@Composable
fun DrawRec(color: Color) {
    val paint = Paint()
    paint.color = color
    Draw { canvas: Canvas, parentSize: PxSize ->
        canvas.drawRect(parentSize.toRect(), paint)
    }
}