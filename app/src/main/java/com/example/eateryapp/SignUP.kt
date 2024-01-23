package com.example.eateryapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUP {
    companion object{
        @Composable
        fun SignUP(navController: NavController){

            val configuration = LocalConfiguration.current
            val screenWidthDp = configuration.screenWidthDp.dp
            val screenHeightDp = configuration.screenHeightDp.dp

            Box(
                modifier = Modifier
                    .width(screenWidthDp)
                    .height(screenHeightDp)
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
                        fontSize = 15.em,
                        modifier = Modifier.padding(40.dp),
                        color = Color.White
                    )
                    Text(
                        text="Enter Your Information",
                        fontSize = 4.em,
                        modifier = Modifier.padding(20.dp),
                        color = Color.White
                    )

                    var nameStore by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value =nameStore ,
                        onValueChange ={ nameStore=it},
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


///////////////////////////////////////////////// Write a message to the database //////////////////////////////////////////////////////////////////

                    val database = Firebase.database
                    val myRef = database.getReference("SignUP Information")

                    val toastContext = LocalContext.current

                    Button(
                        onClick = {
                                if(nameStore.isNotEmpty() and passStore.isNotEmpty() and mailStore.isNotEmpty()){


                                    var data=SingUPData(nameStore,mailStore,passStore)

                                    myRef.child(nameStore).setValue(data)
                                    .addOnSuccessListener {
                                        nameStore=""
                                        mailStore=""
                                        passStore=""
                                    Toast.makeText(toastContext,"Account has been successfully created",Toast.LENGTH_SHORT).show()

                                    }.addOnFailureListener {
                                        Toast.makeText(toastContext,it.toString(),Toast.LENGTH_SHORT).show()
                                    }
                                }
                            else {
                                Toast.makeText(toastContext,"Please Insert All The Value",Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .padding(5.dp)
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
                            fontSize = 4.em,
                            modifier = Modifier.padding(20.dp),
                            color = Color.White
                        )
                        Text(
                            text="Login",
                            fontSize = 4.em,
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