package com.example.myapplication.activities

import android.app.ActionBar
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity


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
import androidx.ui.foundation.shape.corner.CornerSizes
import androidx.ui.foundation.shape.corner.RoundedCornerShape

import androidx.ui.graphics.Color
import androidx.ui.graphics.vectorgraphics.VerticalGradient
import androidx.ui.layout.*
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.FloatingActionButton
import androidx.ui.material.surface.Card
import androidx.ui.material.themeColor
import androidx.ui.material.themeTextStyle

import androidx.ui.painting.imageFromResource
import androidx.ui.text.TextStyle
import androidx.ui.vector.VectorScope
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.activities.ProductListActivity
import com.example.myapplication.control.Category
import com.example.myapplication.control.Product
import com.example.myapplication.control.ShoppingBagProduct
import com.example.myapplication.control.User
import com.example.myapplication.product.DrawRec
import com.example.myapplication.sample.DummyDataProvider
import com.example.myapplication.theme.HeinekenTheme
import java.lang.NullPointerException

class ProductDetailActivity : AppCompatActivity() {
    lateinit var currentProduct: ShoppingBagProduct

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp() {
        val categoryString = intent.getStringExtra("CATEGORY")
        val productString = intent.getStringExtra("PRODUCT")
        if (categoryString.isEmpty() || productString.isEmpty()) {
            startActivity(intent)
        }

        for (category in DummyDataProvider.categories) {
            if (category.name.equals(categoryString)) {
                for (product in category.products!!) {
                    if (product.name.equals(productString)) {
                        currentProduct = ShoppingBagProduct(product, +state { 0 })
                        for (item in User.getInstance().shoppingBag) {
                            if (item.product.equals(product)) {
                                currentProduct = item
                            }
                        }
                    }
                }
            }
        }

        HeinekenTheme {

            Card {
                Align(Alignment.BottomCenter) {
                    ButtonBar(onClick = {
                        onBackPressed()
                    })
                }
            }
        }
    }

    @Composable
    fun RandomButton() {
        Center {
            val onClick: () -> Unit = { Log.e("FABDemo", "onClick") }
            Column(mainAxisAlignment = MainAxisAlignment.SpaceEvenly) {
                //                FloatingActionButton(icon = icon, onClick = onClick)
                FloatingActionButton(text = "EXTENDED", onClick = onClick)
//                FloatingActionButton(icon = icon, text = "ADD TO FAVS", onClick = onClick)
            }
        }
    }



    override fun onBackPressed() {
        try {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("CATEGORY", User.getInstance().getCurrentCategory().name)
            startActivity(intent)
            overridePendingTransition(0, R.anim.slide_down)
        } catch (e: NullPointerException) {
            Toast.makeText(applicationContext, "Whoops something went wrong", Toast.LENGTH_SHORT)
                .show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    @Composable
    fun ButtonBar(onClick: () -> Unit) {
        Card(color = Color.LightGray, shape = androidx.ui.foundation.shape.RectangleShape) {
            Padding(8.dp) {
                FlexRow {
                    inflexible {
                        Card(
                            color = Color(1f, 1f, 1f),
                            shape = RoundedCornerShape(
                                corners = CornerSizes(
                                    30.dp,
                                    30.dp,
                                    30.dp,
                                    30.dp
                                )
                            )
                        ) {
                            Button(
                                color = +themeColor { secondary },
                                text = "-",
                                textStyle = TextStyle(
                                    color = +themeColor { primary },
                                    fontSize = 24.sp
                                ), onClick = {
                                    if (currentProduct.amount.value == 0) {
                                        Toast.makeText(
                                            applicationContext,
                                            "Your value can't go below zero!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        currentProduct.amount.value--

                                    }
                                }
                            )
                        }
                        WidthSpacer(12.dp)
                        Column(mainAxisSize = FlexSize.Min) {
                            Text(
                                text = "" + currentProduct.amount.value,
                                style = +themeTextStyle { subtitle1 })
                            Text(text = "keer", style = +themeTextStyle { subtitle2 })
                        }
                        WidthSpacer(12.dp)
                        Card(
                            color = Color(1f, 1f, 1f),
                            shape = RoundedCornerShape(
                                corners = CornerSizes(
                                    30.dp,
                                    30.dp,
                                    30.dp,
                                    30.dp
                                )
                            )
                        ) {
                            Button(
                                color = +themeColor { secondary },
                                text = "+",
                                textStyle = TextStyle(
                                    color = +themeColor { primary },
                                    fontSize = 24.sp
                                ), onClick = {
                                    currentProduct.amount.value++
                                })
                        }

                    }
                    flexible(1f) {
                        //width from the + / - buttons
                        Row(mainAxisAlignment = MainAxisAlignment.End) {
                            Button(
                                text = "TOEVOEGEN",
                                color = +themeColor { primary },
                                textStyle = TextStyle(color = +themeColor { secondary }),
                                onClick = {
                                    if (currentProduct.amount.value == 0) {
                                        User.getInstance().removeProductFromBag(currentProduct)
                                        onClick()
                                    } else {
                                        User.getInstance().addProductToBag(currentProduct)
                                        onClick()
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, R.anim.slide_down)

    }
}
