package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.compose.*
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.corner.CornerSizes
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.surface.Card
import androidx.ui.material.themeColor
import androidx.ui.material.themeTextStyle
import androidx.ui.painting.Canvas
import androidx.ui.painting.Paint
import com.example.myapplication.MainActivity
import com.example.myapplication.control.Product
import com.example.myapplication.control.User
import com.example.myapplication.sample.DummyDataProvider
import com.example.myapplication.theme.HeinekenTheme
import java.lang.NullPointerException

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeinekenTheme {
                val intent = getIntent()
                val categoryName = intent.getStringExtra("CATEGORY")
                for (category in DummyDataProvider.categories) {
                    if (categoryName.equals(category.name) && !category.products.isNullOrEmpty()) {
                        User.getInstance().setCurrentCategory(category)
                        ActionBarWidget(categoryName)
                        ProductFeed(category.products, onSelected = {
                            val intent = Intent(this, ProductDetailActivity::class.java)
                            intent.putExtra("CATEGORY", categoryName)
                            intent.putExtra("PRODUCT", it.name)
                            startActivity(intent)
                        })
                    }
                }
            }
        }
    }

    @Composable
    fun ActionBarWidget(categoryName: String) {
        val actionBar = this.supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.title = categoryName
        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //item id of the backbutton
        if (item.itemId.equals(16908332)){
            startActivity(Intent(this, MainActivity::class.java))
        }
        return true
    }

    @Composable
    fun ProductFeed(
        products: List<Product>,
        onSelected: (Product) -> Unit
    ) {

        ScrollingList(products) { product ->
            Log.i("TAG123", "product naam: " + product.name)
            ProductViewCard2(product, onClick = { onSelected(product) })
        }
    }

    @Composable
    fun ScrollingList(
        data: List<Product>,
        body: @Composable() (Product) -> Unit
    ) {
        VerticalScroller {
            FlexColumn {
                flexible(1f) {
                    data.forEach { product ->
                        body(product)
                    }
                }
            }
        }
    }

    @Composable
    fun ProductViewCard2(product: Product, onClick: () -> Unit) {
        Clickable(onClick) {
            Card(color = +themeColor { surface }) {
                //card can only hold one child, card is part of the surface class which defines this
                Column {
                    Padding(12.dp) {
                        Container(height = 240.dp, expanded = true) {
                            DrawShape(androidx.ui.foundation.shape.RectangleShape, Color.White)
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
    }
    override fun onBackPressed() {
        try {
            val intent = Intent(this, MainActivity::class.java)
            User.getInstance().deleteCurrentCategory()
            startActivity(intent)
        } catch (e : NullPointerException){
            Toast.makeText(applicationContext, "Whoops something went wrong", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
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
}
