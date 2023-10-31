package com.duonglc.figma.screens.category

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.ui.theme.FigmaTheme

@Composable
fun CategoryScreen(modifier: Modifier =Modifier){

}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "Category Screen Preview")
private fun CategoryScreenPreview(){
    FigmaTheme {
        CategoryScreen()
    }
}