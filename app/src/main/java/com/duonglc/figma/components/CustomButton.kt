package com.duonglc.figma.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.duonglc.figma.ui.theme.*

@Composable
fun SimpleButton(){
    Button(
        onClick = {},
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple200,
            contentColor = EbonyClayColor
        )
    ) {

        Icon(
            Icons.Filled.Settings,
            contentDescription = "Settings",
            modifier = Modifier.offset(
                x = -xs
            )
        )


        Text(
            text = "Simple Button",
            style = MaterialTheme.typography.button
        )
    }
}



@Composable
fun RoundedButton(
    shape : RoundedCornerShape = RoundedCornerShape(md),
    text : String = "Rounded Button",
){
    Button(
        onClick = {},
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple200,
            contentColor = EbonyClayColor
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}



@Composable
fun BorderButton(
    text: String = "Border Button",
    borderColor : Color = EbonyClayColor,
    shape : RoundedCornerShape = RoundedCornerShape(sm),
){
    Button(
        onClick = {},
        border = BorderStroke(
            width = bdw,
            color = borderColor
        ),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = AppPrimaryColor
        )
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.button
        )
    }
}



@Composable
fun ElevationButton(){
    Button(
        onClick = {},
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Purple500,
            contentColor = ColorWhite
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = sm,
            pressedElevation = sm,
            disabledElevation = xs
        )
    ){
        Text(
            text = "Elevation Button",
            style = MaterialTheme.typography.button
        )
    }
}











@Composable
fun DisableButton(){
    Button(
        onClick = {},
        shape = Shapes.medium,
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = Color.LightGray,
            disabledContentColor = EbonyClayColor
        ),
        enabled = false
    ){
        Text(
            text = "Disable Button",
            style = MaterialTheme.typography.button,
            color = lightGray
        )
    }
}





@Composable
fun Space24(){
    Column(
        modifier = Modifier.height(lg)
    ){}
}
