package com.example.eateryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController


data class BottomNavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class BottomNavigationBar {


    companion object{
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun BottomNavigationBar(navController: NavController){

            val items = listOf(
                BottomNavigationItems(
                    title = "Home",
                    selectedIcon = Icons.Filled.Home,
                    unselectedIcon = Icons.Outlined.Home,
                    hasNews = false,
                ),
                BottomNavigationItems(
                    title = "Cart",
                    selectedIcon = Icons.Filled.ShoppingCart,
                    unselectedIcon = Icons.Outlined.ShoppingCart,
                    hasNews = false,
                    badgeCount = 420
                ),
                BottomNavigationItems(
                    title = "Settings",
                    selectedIcon = Icons.Filled.Settings,
                    unselectedIcon = Icons.Outlined.Settings,
                    hasNews = true,
                ),
            )

            var selectedItemIndex by rememberSaveable {
                mutableStateOf(0)
            }


            Scaffold(
                bottomBar = {
                    NavigationBar(
                        containerColor  = Color.Black,
//                        modifier = Modifier.background(Color.Red)
                    ) {
                        items.forEachIndexed {
                         index, item ->
                            NavigationBarItem(



                                colors = NavigationBarItemDefaults.colors(Color.White),


                                
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    // navController.navigate(item.title)
                                },
                                label = {
                                    Text(text = item.title)
                                },
                                alwaysShowLabel = false,
                                icon = {
                                    BadgedBox(
                                        badge = {
                                            if(item.badgeCount != null) {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            }


//                                                else if(item.hasNews) {
//                                                    Badge()
//                                                }   //apatoto no needed
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if (index == selectedItemIndex) {
                                                item.selectedIcon
                                            } else item.unselectedIcon,
                                            contentDescription = item.title
                                        )
                                    }
                                }
                            )
                        }
                    }
                }
            ) {
                    Class06.View06(navController = navController)
            }

        }
    }
}