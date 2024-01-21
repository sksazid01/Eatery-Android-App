package com.example.eateryapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class SignUP {
    companion object{
        @Composable
        fun SignUP(navController: NavController){
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
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 60.sp,
                        modifier = Modifier.padding(40.dp),
                        color = Color.White
                    )
                    Text(
                        text="Enter Your Information",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(20.dp),
                        color = Color.White
                    )

                    var name by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value =name ,
                        onValueChange ={ name=it},
                        singleLine = true,
                        label = { Text(text = "User Name")},
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp)
                    )

                    var mailStore by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value =mailStore ,
                        onValueChange ={ mailStore=it},
                        singleLine = true,
                        label = { Text(text = "Email")},
//                            colors = TextFieldDefaults.colors()
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp)
                    )

                    var passStore by remember {mutableStateOf("") }
                    OutlinedTextField(value = passStore , onValueChange = { passStore=it},
                        singleLine = true,
                        label = { Text(text = "Password")},
//                            colors = TextFieldDefaults.colors()
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        shape = RoundedCornerShape(20.dp))

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .padding(30.dp)
                            .size(300.dp, 50.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(50.dp)

                    ) {
                        Text(
                            text = "Sign Up",
                            color = Color.White,
//                                fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text="Already have an account,",
                            fontSize = 20.sp,
                            modifier = Modifier.padding(20.dp),
                            color = Color.White
                        )
                        Text(
                            text="Login",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(5.dp)
                                .clickable {
                                   navController.navigate("Login")
                                },
                            color = Color.Blue
                        )

                    }

                }
            }
        }}}