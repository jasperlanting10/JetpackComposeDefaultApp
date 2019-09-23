package com.example.myapplication.activities

import android.app.ActionBar
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ActionBarContainer
import androidx.compose.*
import androidx.core.content.ContextCompat
import androidx.ui.core.*
import androidx.ui.core.vectorgraphics.DrawVector
import androidx.ui.core.vectorgraphics.VectorAsset
import androidx.ui.core.vectorgraphics.compat.VectorResource
import androidx.ui.core.vectorgraphics.compat.loadVectorResource

import androidx.ui.graphics.Color
import androidx.ui.graphics.vectorgraphics.VerticalGradient
import androidx.ui.layout.*
import androidx.ui.layout.Column
import androidx.ui.material.surface.Card

import androidx.ui.painting.imageFromResource
import androidx.ui.text.TextStyle
import androidx.ui.vector.VectorScope
import com.example.myapplication.R
import com.example.myapplication.activities.ProductListActivity
import com.example.myapplication.control.Category
import com.example.myapplication.control.Product
import com.example.myapplication.sample.DummyDataProvider
import com.example.myapplication.theme.HeinekenTheme

class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        HeinekenTheme {
            Card(color = Color.LightGray, shape = androidx.ui.foundation.shape.RectangleShape) {
                Align(Alignment.BottomCenter) {
                    ButtonBar()
                }
            }
        }
    }


    @Composable
    fun ButtonBar() {
        Padding(8.dp) {
            FlexRow {
                inflexible {
                    Row(mainAxisSize = FlexSize.Min) {
//                        Button(
//                            text = "-", style = ButtonStyle(
//                                elevation = 8.dp,
//                                color = Color.White,
//                                shape = RoundedCornerShape(30.dp, 30.dp, 30.dp, 30.dp),
//                                textStyle = TextStyle(
//                                    color = +themeColor { primary }, fontSize
//                                    = 18.sp
//                                )
//                            ), onClick = {
//                                productCount.value--
//                            }
//                        )
                        WidthSpacer(12.dp)
                        Button(text = "dit is nog een knop", color = Color.Green)
                    }

                }
                expanded(1f) {
                    Button(text = "TOEVOEGEN", color = Color.Green)
                }
            }
        }
    }
}
