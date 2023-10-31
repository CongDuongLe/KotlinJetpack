package com.duonglc.figma.screens.home
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.ui.theme.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.padding(md)
    ){
//        SimpleButton()
//        Space24()
//        DisableButton()
//        Space24()
//        RoundedButton()
//        Space24()
//        BorderButton()
//        Space24()
//        ElevationButton()
//        OTPTextField()
    }
}






@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomePreview() {
    FigmaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background

        ){

        HomeScreen()
        }
    }
}