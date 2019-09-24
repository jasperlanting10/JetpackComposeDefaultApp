package com.example.myapplication

import android.app.ActionBar
import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.ActionBarContainer
import androidx.compose.*
import androidx.core.content.ContextCompat
import androidx.ui.core.Px
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.core.vectorgraphics.DrawVector
import androidx.ui.core.vectorgraphics.VectorAsset
import androidx.ui.core.vectorgraphics.compat.VectorResource
import androidx.ui.core.vectorgraphics.compat.loadVectorResource
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Dialog
import androidx.ui.foundation.SimpleImage
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.graphics.vectorgraphics.VerticalGradient
import androidx.ui.layout.*
import androidx.ui.layout.Column
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Card
import androidx.ui.material.themeColor
import androidx.ui.material.themeTextStyle
import androidx.ui.painting.imageFromResource
import androidx.ui.vector.VectorScope
import com.example.myapplication.activities.ProductListActivity
import com.example.myapplication.control.Category
import com.example.myapplication.control.Product
import com.example.myapplication.control.User
import com.example.myapplication.sample.DummyDataProvider
import com.example.myapplication.theme.HeinekenTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
    @Composable
    fun MyApp(){
        HeinekenTheme {
            ActionBarWidget()

            val products = DummyDataProvider.categories
            Card(color = Color.LightGray) {
                CategoryFeed(products, onSelected = {
                    OnItemSelected(it)
                })
            }


        }
    }
    @Composable
    fun ActionBarWidget(){
        val actionBar = this.supportActionBar

        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar!!.setDisplayUseLogoEnabled(true)

        actionBar!!.title = "Drinkies"

    }

    @Composable
    fun OnItemSelected(category: Category) {
        Log.i("TAG123", "category list: " + category.products.toString())
        if (category.products == null) {
            Toast.makeText(
                getApplicationContext(),
                "No products in this category yet",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val intent = Intent(this, ProductListActivity::class.java)
            intent.putExtra("CATEGORY", category.name)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right,R.anim.stay)

        }
    }

    @Composable
    fun ImageCard() {
//        Card {

//            Log.i("TAG123", "resources: "+resources + ", "+R.drawable.ic_logo)
//            val image = imageFromResource(resources, R.drawable.ic_launcher_foreground)
//            SimpleImage(image)


//            val drawable = resources.getDrawable(R.drawable.ic_logo, theme)
////            SimpleImage(drawable)
//
//            val vectorImage =
//                loadVectorResource(applicationContext.theme, resources, R.drawable.ic_logo)
//            Log.i("TAG123", "vector data: "+vectorImage.toString())
//            DrawVector(vectorImage)

//        }
    }

    @Composable
    fun CategoryFeed(
        categories: List<Category>,
        onSelected: (Category) -> Unit
    ) {

        ScrollingList(categories) { category ->
            CategoryViewItem(category, onClick = {
                Log.i("TAG123", "category name: "+category.name)
                onSelected(category)
            })
        }
    }

    @Composable
    fun ScrollingList(
        data: List<Category>,
        body: @Composable() (Category) -> Unit
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
    fun CategoryViewItem(category: Category, onClick : () -> Unit) {
        Clickable(onClick) {
            Card {
                //card can only hold one child, card is part of the surface class which defines this
                Column {
                    Container(height = 240.dp, expanded = true){
                        DrawShape(androidx.ui.foundation.shape.RectangleShape, Color.White)
                        Align(Alignment.BottomCenter) {
                            Column(
                                mainAxisSize = FlexSize.Min,
                                mainAxisAlignment = MainAxisAlignment.End,
                                crossAxisSize = FlexSize.Max,
                                crossAxisAlignment = CrossAxisAlignment.Start
                            ) {
                                DrawShape(
                                    shape = androidx.ui.foundation.shape.RectangleShape, brush = VerticalGradient(
                                        Color.White,
                                        Color.Black,
                                        startY = Px.Zero,
                                        endY = Px(250.0f)
                                    )
                                )
                                Padding(12.dp, top = 18.dp) {
                                    Text(text = category.name, style = +themeTextStyle { h4 })
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val currentProducts = User.getInstance().shoppingBag

        for (item in currentProducts){
            Log.i("TAG123", "shopping bag item: "+item.product.name + ", amount: "+item.amount)
        }
    }
}
