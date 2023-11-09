package com.duonglc.figma.screens.home
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.duonglc.figma.ui.theme.*

@Composable
fun HomeScreen(
    openCategoryAction: () -> Unit,
    openMyAccountScreen: () -> Unit,
    editCustomerInfo: ()-> Unit,
    openAddressBook: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Home Screen")
        Spacer(modifier = Modifier.height(lg))
        Button(onClick = { openCategoryAction() }) {
            Text("Open Category")
        }
        Spacer(modifier = Modifier.height(lg))
        Button(onClick = {
            openMyAccountScreen()
        }) {
            Text(text = "Open MyAccount")
        }

        Spacer(modifier = Modifier.height(lg))
        Button(onClick = {
            openAddressBook()
        }) {
            Text(text = "Open Address Book")
        }
        Spacer(modifier = Modifier.height(lg))
        Button(onClick = {
            editCustomerInfo()
        }) {
            Text(text = "Edit customer information")
        }

    }
}





