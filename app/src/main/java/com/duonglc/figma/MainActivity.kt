package com.duonglc.figma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.screens.ScreenTypes
import com.duonglc.figma.screens.category.CategoryScreen
import com.duonglc.figma.screens.video_detail.VideoDetailScreen
import com.duonglc.figma.ui.theme.FigmaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FigmaTheme {
                // A surface container using the 'background' color from the theme
                    MainApp()

                }
            }
        }
    }



@Composable
fun MainApp(){
    var currentScreen by remember { mutableStateOf(ScreenTypes.DETAIL) }

    Surface(
        modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
    ) {
        if (currentScreen === ScreenTypes.DETAIL) {
            VideoDetailScreen(){
                currentScreen = ScreenTypes.CATEGORY
            }
        } else {
            CategoryScreen()
        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    FigmaTheme {
        MainApp()
    }
}


