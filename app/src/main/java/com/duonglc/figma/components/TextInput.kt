package com.duonglc.figma.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.runtime.Composable

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextInput() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {e: String -> text = e },
        label = { Text("Label") },
        maxLines = 2,
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    // Icons.Filled.Favorite,
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = null
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    // Icons.Filled.Favorite,
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )
            }
        },
        placeholder = {
              Text(text = "Placeholder", style = TextStyle(color = Color.Gray))
        },
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}


@Composable
fun TextInputView() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ){

    TextInput()
    }
}








@Composable
@Preview(showBackground = true)

fun TextInputPreview() {
    TextInputView()
}