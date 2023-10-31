package com.duonglc.figma.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duonglc.figma.R

@ExperimentalMaterialApi



@Composable
fun InfiniteHeart() {
    // renderInfiniteHeart
    val infiniteTransition = rememberInfiniteTransition()

    val heartSize by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = FastOutSlowInEasing
            ),

            repeatMode = RepeatMode.Reverse
        )
    )

    Image(
        painter = painterResource(R.drawable.ic_heart),
        contentDescription = "Heart",
        modifier = Modifier
            .size(heartSize.dp)
    )

}



@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview

fun DefaultPreview() {
    InfiniteHeart()
}
