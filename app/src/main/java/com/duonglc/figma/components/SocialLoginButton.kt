package com.duonglc.figma.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.ui.theme.*
import com.duonglc.figma.R

@OptIn(ExperimentalMaterialApi::class)
@Composable

fun GoogleButton(
    text: String = "Sign Up With Google",
    loadingText : String = "Creating Account",
    shape : Shape = Shapes.medium,
    onPress : () -> Unit = {},
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_google,
    bg : Color = Color.White,
){

    var clicked by remember { mutableStateOf(false) }

    Surface (
        shape = shape,
        border = BorderStroke(
            width = bdw,
            color = EbonyClayColor
        ),
        color = ColorWhite,
        modifier = modifier.clickable {
             clicked = !clicked
            onPress()
        },

    ){
        Row(
            modifier = Modifier.
                    padding(
                        top = SMALL_PADDING,
                        bottom = SMALL_PADDING,
                        start = MEDIUM_PADDING,
                        end = MEDIUM_PADDING
                    )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ){
            Icon(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(smIcon),
                tint = Color.Unspecified
            )
            Spacer(
                modifier = Modifier.width(xs)
            )
            Text(
                text = if (clicked) loadingText else text,
                color = AppPrimaryColor,

            )
            if (clicked){
                Spacer(
                    modifier = Modifier.width(md)
                )
                CircularProgressIndicator(
                    modifier = Modifier.size(md),
                    strokeWidth = strokewidth,
                    color = AppPrimaryColor
                )
            }
            onPress()

        }



    }


}




@Preview (showBackground = true)
@Composable

private  fun PreviewGoogleButton(){
    GoogleButton()
}