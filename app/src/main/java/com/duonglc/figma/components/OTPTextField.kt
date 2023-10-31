package com.duonglc.figma.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.duonglc.figma.ui.theme.Black
import com.duonglc.figma.ui.theme.md
import com.duonglc.figma.ui.theme.sm


@Composable
fun OTPTextField(){

    var otpCode by remember { mutableStateOf("") }

    BasicTextField(
        value = otpCode,
        onValueChange = { newValue ->
            otpCode = newValue
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    ){

    Row(
        horizontalArrangement = Arrangement.spacedBy(md)
    ){


        repeat(6){ index ->
        val number  =  when {
            index >= otpCode.length -> ""
            else -> otpCode[index].toString()
        }
            OTPTextFieldItem(
                number = number
            )
        }
    }
    }
}

@Composable
fun OTPTextFieldItem(
    number : String = ""
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(sm)
    ) {
        Text(
            text = number,
            style = MaterialTheme.typography.body1,
        )

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(2.dp)
                .background(Black)
        )

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewOTPTextField(){
    OTPTextField()
}