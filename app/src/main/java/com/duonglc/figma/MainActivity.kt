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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.navigation.AppNavigator
import com.duonglc.figma.ui.theme.FigmaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                    MainApp()
            }
        }
    }



@Composable
fun MainApp(){
//    var currentScreen by remember { mutableStateOf(ScreenTypes.DETAIL) }

    Surface(
        modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
    ) {
//        if (currentScreen === ScreenTypes.DETAIL) {
//            VideoDetailScreen(){
//                currentScreen = ScreenTypes.CATEGORY
//            }
//        } else {
//           CategoryScreen { productId ->
//                currentScreen = ScreenTypes.DETAIL }
//        }
        AppNavigator()
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    FigmaTheme {
        MainApp()
    }
}


