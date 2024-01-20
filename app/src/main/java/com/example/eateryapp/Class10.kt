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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class RestaurantItems(
    var itemName: String,
    var price:Int,
    var image: Painter,
    var id:Int
)
class Class10 {
        companion object{
            @Composable
            fun View10(navController: NavController){
                Box(
//                        contentAlignment = Alignment.Center,
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
                    Column(
                        modifier = Modifier.padding(30.dp)
                    ) {

                        val itm = List(2) {
                                index->
                            RestaurantItems(
                                itemName = "Chicken Khichuri",
                                price = 120,
                                image = painterResource(id = R.drawable.chickenkkhichuri),
                                id=index
                            )}
                            
                        Text(text = "2 items in cart", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
                        LazyColumn(content = {
                            items(itm){
                                item->
                                CartItem(item)
                            }
                        })
                        Spacer(modifier = Modifier.weight(1f))
                        
                        Text("Order instructions",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 5.dp, start = 5.dp)
                        )
                        var textfield by remember {mutableStateOf("") }
                        TextField(
                            value =textfield ,
                            onValueChange ={ textfield=it},
                            singleLine = true,
                            label = { Text(text = "Provide a short instruction")},
//                            colors = TextFieldDefaults.colors()
                            modifier=Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp)
                        )
                        Text(text = "Total: ", fontWeight = FontWeight.ExtraBold)
                        Button(
                            onClick = { /*TODO*/ },
                            modifier= Modifier
                                .fillMaxWidth()
                                .height(50.dp),
//                                .background(Color(0xFF644AB5)), wrong approach
                            colors = ButtonDefaults.buttonColors(Color(0xFF644AB5)),
                            shape = RoundedCornerShape(30.dp)
                        ) {
                            Text(
                                text = "Checkout",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 30.sp
                            )
                        }
                        Row {

                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text="Back to Menu",
                            fontWeight = FontWeight.ExtraBold
//                                modifier = Modifier.
//                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                        Spacer(modifier = Modifier.height(80.dp))

                    }
                }}
        @Composable
        fun CartItem(item: RestaurantItems){
           Card (
               modifier = Modifier
                   .padding(5.dp)
                   .height(90.dp)
                   .background(Color.Transparent)
                   .fillMaxWidth()
           ){
               Row(
                   modifier = Modifier
                       .fillMaxSize()
                       .background(Color.Transparent)
               ) {
                   Image(painter = item.image, contentDescription ="" ,
                       alignment = Alignment.CenterStart,
                       modifier = Modifier.size(90.dp),
//                       contentScale = ContentScale.Fit,
                   )
                   Spacer(modifier = Modifier.weight(1f))
                   Column(
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ) {
                       Text(text = item.itemName)
                       Text(text = item.price.toString()+"৳",
//                           textAlign = TextAlign.Center
                           )
                       Row {
                           Icon(imageVector = Icons.Default.Add, contentDescription = "",modifier = Modifier.clickable {

                           })
                           Text(text = " 1 ")
                           Icon(painter = painterResource(id = R.drawable.baseline_remove_24), contentDescription ="",modifier = Modifier.clickable {

                           } )
                       }
                   }
               Spacer(modifier = Modifier.weight(1f))
               Icon(imageVector = Icons.Default.Clear, contentDescription = "", modifier = Modifier.clickable {

               })
           }}
        }
        }
}