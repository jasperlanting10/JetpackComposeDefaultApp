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
import com.example.myapplication.R
import com.example.myapplication.activities.ProductListActivity
import com.example.myapplication.control.Category
import com.example.myapplication.control.Product
import com.example.myapplication.sample.DummyDataProvider
import com.example.myapplication.theme.HeinekenTheme

class ImagePractise : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    @Composable
    fun MyApp(){
        HeinekenTheme {
            val image = imageFromResource(resources, R.mipmap.ic_drinkies_launcher)
            SimpleImage(image)
//            val vectorImage =
//                loadVectorResource(applicationContext.theme, resources, R.drawable.ic_logo)
//            Log.i("TAG123", "vector data: "+vectorImage.toString())
//            DrawVector(vectorImage)
        }
    }
}
