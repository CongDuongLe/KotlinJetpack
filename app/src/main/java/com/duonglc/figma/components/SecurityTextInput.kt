package com.duonglc.figma.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.size.Size
import com.duonglc.figma.ui.theme.grayColor
import com.duonglc.figma.ui.theme.md
import com.duonglc.figma.R
import com.duonglc.figma.ui.theme.lg
import com.duonglc.figma.ui.theme.sm

@Composable
fun SecurityTextInput(
    textColor: Color = Color(android.graphics.Color.parseColor(grayColor[900]!!)),
    placeHolderTextColor : Color = Color(android.graphics.Color.parseColor(grayColor[700]!!)),
    label : String = "Password",
    placeholder: String = "Input your password",
    icon : Int = R.drawable.ic_eye,
    iconUnHide : Int = R.drawable.ic_eye_slash
){
    var text by remember { mutableStateOf("") }

    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = label) },
        maxLines = 2,
        trailingIcon = {

            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    painter = painterResource(id =
                        if (isPasswordVisible) iconUnHide else icon
                    ),
                    contentDescription = "icon",
                    modifier = Modifier.padding(md).size(lg),
                    tint = Color.Unspecified

                )
            }
        },
        placeholder = {
              Text(text = placeholder, style = TextStyle(color = placeHolderTextColor))
        },
        textStyle = TextStyle(color = textColor, fontWeight = FontWeight.Bold, fontSize = 16.sp ),
        modifier = Modifier.padding(sm),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}

@Composable
@Preview(showBackground = true)

private fun PreviewSecurityTextInput(){
    SecurityTextInput()
}