package com.duonglc.figma.screens.customer

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import com.duonglc.figma.screens.NavigationItem
import com.duonglc.figma.ui.theme.lg
import kotlinx.parcelize.Parcelize
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


@Parcelize
data class Address(
    val id:Int = 1,
    val street:String = "",
    val city:String = "",

    ) : Parcelable {
        override fun toString(): String {
            return adapter().toJson(this)
        }
        companion object {
            fun from(value: String) = adapter().fromJson(value) ?: Address()
            fun adapter(): JsonAdapter<Address> =
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build().adapter(Address::class.java)
        }

    }


class AddressNavType: NavType<Address>(isNullableAllowed = true) {

    override fun get(bundle: Bundle, key: String): Address? {
        return bundle.getParcelable<Address>(key)
    }

    override fun parseValue(value: String): Address {
        return Address.from(value)
    }

    override fun put(bundle: Bundle, key: String, value: Address) {
        bundle.putParcelable(key, value)
    }
}

object AddressBookNavigation {

    const val addressArg = "parametersArg"
    const val route = "addressBook?${addressArg}={$addressArg}"

    fun createRoute(addresses: Address): String {
        val encoded = Uri.encode(addresses.toString())
        val route = "${NavigationItem.AddressBook.route}?${addressArg}=$encoded"
        Log.e("route", "route $route")
        return route
    }

    fun fromNav(navBackStackEntry: NavBackStackEntry): Address? {
        return navBackStackEntry.arguments?.getParcelable(addressArg)
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddressBookScreen(addresses: List<Address?>, onBack: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBar() {
                Text(
                    text = "AddressBook",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(lg),
            modifier = Modifier.padding(lg),
        ) {
            items(addresses) { address ->
                Text(text = address.toString())
            }
        }

    }

    BackHandler() {
        onBack()
    }
}