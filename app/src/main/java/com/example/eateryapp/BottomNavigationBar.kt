package com.example.eateryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


data class BottomNavigationItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class BottomNavigationBar {
    companion object{
        @Composable
        fun BottomNavigationBar(){
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


            val navController = rememberNavController()


            Scaffold(
                bottomBar = { BottomBar(items) }
            ) {
                NavHost(navController = navController, startDestination = "Class06") {
                    composable("Class06"){ Class06.View06(navController)}
                    composable("QR"){QR.Qr(navController)}
//                composable("Class0"){ Class0.View0()}
                }
            }
        }

        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun BottomBar(items:List<BottomNavigationItems>)
            {
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                NavigationBar(
                    containerColor  = Color.Black,
//                    modifier = Modifier.height(50.dp)

                ) {
                    items.forEachIndexed {
                            index, item ->


                        NavigationBarItem(
//                            colors = NavigationBarItemDefaults.colors(Color(0xFFBB6748)),
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                // navController.navigate(item.title)
                            },
                            label = {
                                Text(text = item.title,
//                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            },
//                            alwaysShowLabel = false,
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if(item.badgeCount != null) {
                                            Badge {
                                                Text(text = item.badgeCount.toString())
                                            }
                                        }


                                                else if(item.hasNews) {
                                                    Badge()
                                                }   //apatoto no needed
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else item.unselectedIcon,
                                        contentDescription = "",
                                        tint = if(index == selectedItemIndex) Color.Blue else Color(0xFFBB6748)
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }

}