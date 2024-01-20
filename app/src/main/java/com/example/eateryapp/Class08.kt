package com.example.eateryapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


class Class08 {
    companion object{
        @Composable
        fun View08(navController: NavController){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFF5E667),
                                Color(0xFFED8888)
                            ),
                            start = Offset.Zero,
                            end = Offset.Infinite,
                            tileMode = TileMode.Decal
                        )
                    )
            ){
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.resturant),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            text = "Sobuj Bangla",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
//                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(35.dp))

                    var address by remember { mutableStateOf("") }

                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        TextField(
                            value = address, onValueChange = { newText -> address = newText },
                            shape = RoundedCornerShape(15.dp),
                            modifier = Modifier
                                .width(350.dp)
                                .height(30.dp),
                            singleLine = true,
                            label = {
                                Row {
                                    Icon(imageVector = Icons.Default.Search, contentDescription = "")
                                    Spacer(modifier = Modifier.width(25.dp))
                                    Text(
                                        "Search Items...",
                                        color = Color.Gray,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            },
//                       colors = TextFieldDefaults.colors()
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(35.dp))

                    var resList = List(17) {
                        index->
                        RestaurantItems(
                            itemName = "Chicken Khichuri",
                            price = 120,
                            image = painterResource(id = R.drawable.chickenkkhichuri),
                            id=index
                        )
//                        ,RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),RestaurantItems(
//                            itemName = "Chicken Khichuri",
//                            price = 120,
//                            image = painterResource(id = R.drawable.chickenkkhichuri),
//                        ),
                    }


                    LazyVerticalGrid(columns = GridCells.Fixed(2), content ={
                        items(resList){
                                item->
                            RestaurantCard(item)
                        }
//                        Spacer(modifier = Modifier.height(200.dp))
                    } )
                }
            }
        }

        @Composable
        fun RestaurantCard(item:RestaurantItems){

            val itemName=item.itemName
            val price=item.price
            val image=item.image
            val id=item.id
            var isSelected by remember { mutableStateOf(false) }
            val borderColor= Color.Transparent


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
//                    .background(if(isSelected) Color.Red else borderColor)
                    .clickable {
                        isSelected=!isSelected;
                }
                    .background(if(isSelected) Color.Red else borderColor)
                ) {
                Card(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(180.dp),
//                    .clip(CircleShape),
//                    colors = CardDefaults.cardColors(Color(0xFF84A59D)),
                    colors=CardDefaults.cardColors(Color.Transparent),
                    shape = RoundedCornerShape(20.dp),

                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ){
                        Image(
                            painter = image,
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )

                        Box(
                            Modifier
                                .background(
                                    shape = CircleShape,
                                    color = Color.White
                                )
                                .padding(5.dp)
                        ) {
                            Text(
                                text = price.toString() + "৳",
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }


                }
                Text(
                    text = itemName,
                    textAlign = TextAlign.Left,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            }
        }
    }
