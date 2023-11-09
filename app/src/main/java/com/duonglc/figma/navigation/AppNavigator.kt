package com.duonglc.figma.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.duonglc.figma.screens.NavigationItem
import com.duonglc.figma.screens.catalog.category.CategoryScreen
import com.duonglc.figma.screens.catalog.product.ProductDetailScreen
import com.duonglc.figma.screens.checkout.CheckoutScreen
import com.duonglc.figma.screens.checkout.CheckoutSuccessScreen
import com.duonglc.figma.screens.customer.*
import com.duonglc.figma.screens.home.HomeScreen
import com.duonglc.figma.ui.theme.FigmaTheme

@Composable
fun AppNavigator() {
    val navController = rememberNavController()

    FigmaTheme {
        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route
        ){
            // Home
            composable(
                route = NavigationItem.Home.route
            ){
                HomeScreen(
                    openCategoryAction = {
                        navController.navigate(NavigationItem.Category.route)
                    },
                    openMyAccountScreen = {
                        navController.navigate(NavigationItem.MyAccount.route)
                    },
                    editCustomerInfo = {
                        navController.navigate(NavigationItem.CustomerInfo.route)
                    },
                    openAddressBook = {
                        val address = Address(id = 1, street = "hoang hoa tham", city = "ha noi")
                        navController.navigate(AddressBookNavigation.createRoute(address))
                    }
                )
            }
            // Category
            composable(
                route = NavigationItem.Category.route
            ){
                CategoryScreen(
                    openProductDetail = {
                        productId -> navController.navigate(
                            "${NavigationItem.ProductDetail.route}/$productId"
                        )
                    }
                )
            }

            // Product Detail
            composable(
                route = "${NavigationItem.ProductDetail.route}/{productId}",
                arguments = listOf(
                    navArgument(name = "productId"){
                        type = NavType.StringType
                    }
                )
            ){
                navBackStackEntry ->
                    val productId = navBackStackEntry.arguments?.getString("productId")!!

                 ProductDetailScreen(
                   productId = productId,
                   checkout = {
                       cartId, customerId -> navController.navigate(
                           "${NavigationItem.Checkout.route}/$cartId/$customerId"
                       )
                   }

               )
            }

            // Checkout
            composable(
                route = "${NavigationItem.Checkout.route}/{cartId}/{customerId}",
                arguments = listOf(
                    navArgument(name = "cartId"){
                        type = NavType.StringType
                    },
                    navArgument(name = "customerId"){
                        type = NavType.StringType
                    }
                )
            ){
               navBackStackEntry -> navBackStackEntry.arguments?.let {
                    val cartId = it.getString("cartId")!!
                    val customerId = it.getString("customerId")!!

                    CheckoutScreen(
                        cartId = cartId,
                        customerId = customerId,
                        placeOrderAction = {
                            navController.navigate(NavigationItem.CheckoutSuccess.route)
                        }
                    )
                }
            }

            // Checkout success
            composable(
                route = NavigationItem.CheckoutSuccess.route
            ){
                CheckoutSuccessScreen(
                    goHomeAction = {
                        navController.navigate(NavigationItem.Home.route){
                            popUpTo(NavigationItem.Home.route){
                                inclusive = true
                            }
                        }
                    },
                    viewOrderDetailAction = {
                        detail -> navController.navigate(
                            "${NavigationItem.AddressDetail.route}/$detail"
                        )
                    }
                )
            }

            // adddress detail

            composable(
                route = "${NavigationItem.AddressDetail.route}/{addressId}",
                arguments = listOf(
                    navArgument(name = "addressId"){
                        type = NavType.StringType
                    }
                )

            ){
                navBackStackEntry ->
                    val addressId = navBackStackEntry.arguments?.getString("addressId")!!

                 AddressDetailScreen(
                   addressId = addressId,
                   saveAddressAndBack = {
                       address -> navController.navigateUp()
                   }

               )
            }

            // My account
            composable(route= NavigationItem.MyAccount.route){
                MyAccountScreen(
                    navController = navController,
                    openAddressScreen = {
                        addressId -> navController.navigate(
                            "${NavigationItem.AddressDetail.route}/$addressId"
                         )
                    }
                )
            }

            // Customer Info
            composable(route = NavigationItem.CustomerInfo.route){
                CustomerInfoScreen(
                    onClickBack = {
                        navController.popBackStack()
                    }
                )
            }


            // open Address book
            composable(
                route = NavigationItem.AddressBook.route,
                arguments = listOf(
                    navArgument(
                        name = AddressBookNavigation.addressArg
                    ){
                        nullable = true
                        type = AddressNavType()
                    }
                )
            ){
                val address = AddressBookNavigation.fromNav(it)
               AddressBookScreen(
                   addresses = listOf(address),
                   onBack = {
                       navController.popBackStack()
                   }
               )
            }





        }
    }

}