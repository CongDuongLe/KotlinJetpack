package com.duonglc.figma.screens

enum class ScreenTypes{
    HOME,
    CATEGORY,
    SEARCH,
    LIBRARY,
    SETTING,
    DETAIL,
    CART,
    PRODUCT_DETAIL,
    PRODUCT_LIST,
    CHECKOUT,
    CHECKOUT_SUCCESS,
    ADDRESS_DETAIL,
    CUSTOMER_INFO,
    MY_ACCOUNT,
    VIDEO_DETAIL,
    ADDRESS_BOOK
}



// define screen name and route
sealed class NavigationItem(val route : String){
    object Home : NavigationItem(ScreenTypes.HOME.name)
    object Cart : NavigationItem(ScreenTypes.CART.name)
    object Category : NavigationItem(ScreenTypes.CATEGORY.name)
    object Search : NavigationItem(ScreenTypes.SEARCH.name)
    object Library : NavigationItem(ScreenTypes.LIBRARY.name)
    object Setting : NavigationItem(ScreenTypes.SETTING.name)
    object Detail : NavigationItem(ScreenTypes.DETAIL.name)
    object ProductDetail : NavigationItem(ScreenTypes.PRODUCT_DETAIL.name)
    object ProductList : NavigationItem(ScreenTypes.PRODUCT_LIST.name)
    object Checkout : NavigationItem(ScreenTypes.CHECKOUT.name)
    object CheckoutSuccess : NavigationItem(ScreenTypes.CHECKOUT_SUCCESS.name)
    object AddressDetail : NavigationItem(ScreenTypes.ADDRESS_DETAIL.name)
    object CustomerInfo : NavigationItem(ScreenTypes.CUSTOMER_INFO.name)
    object MyAccount : NavigationItem(ScreenTypes.MY_ACCOUNT.name)
    object VideoDetail : NavigationItem(ScreenTypes.VIDEO_DETAIL.name)
    object AddressBook: NavigationItem(ScreenTypes.ADDRESS_BOOK.name)


}

