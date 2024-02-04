package com.example.eateryapp.Data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.eateryapp.R

data class RestaurantItems(
    var itemName: String,
    var price:Int,
    var image: Painter,
    var id:Int,
    var numberOfSelection:Int,
    var isSelected:Boolean
)

data class RestaurantName(
    var name:String,
    var status:Boolean,
    var id:Int,
    var resitem:List<RestaurantItems>
)




var totalItemInCart:Int=0

var selectedResID = -1

var itm:List<RestaurantItems> = emptyList()

var resName:List<RestaurantName> = emptyList()

@Composable
fun LoadData() {
    itm = listOf( RestaurantItems(
        itemName = "Chicken Khichuri",
        price = 120,
        image = painterResource(id = R.drawable.chickenkkhichuri),
        id = 0,
        numberOfSelection = 0,
        isSelected = false
    ),
        RestaurantItems(
            itemName = "Beef",
            price =130 ,
            image = painterResource(id = R.drawable.beef),
            id = 1,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Beef Biriany",
            price =180 ,
            image = painterResource(id = R.drawable.beefbiriany),
            id = 2,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Beef Kacchi",
            price = 210,
            image = painterResource(id = R.drawable.beefkacchi),
            id = 3,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Coke",
            price = 60,
            image = painterResource(id = R.drawable.coke),
            id = 4,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Jhal Fry",
            price = 95,
            image = painterResource(id = R.drawable.jhalfry),
            id = 5,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Mutton",
            price = 160,
            image = painterResource(id = R.drawable.mutton),
            id = 6,
            numberOfSelection = 0,
            isSelected = false
        ),
        RestaurantItems(
            itemName = "Naan",
            price = 20,
            image = painterResource(id = R.drawable.naan),
            id = 7,
            numberOfSelection = 0,
            isSelected = false
        ), RestaurantItems(
            itemName = "Mojo",
            price =25 ,
            image = painterResource(id = R.drawable.mojo),
            id = 8,
            numberOfSelection = 0,
            isSelected = false
        ),
    )

    resName =listOf(
        RestaurantName(
            name = "Central Cafeteria,SUST",
            status = true,
            id = 0,
            resitem = itm.shuffled()
        ),
        RestaurantName(
            name = "Shah Poran Hall,Canteen",
            status = true,
            id = 1,
            resitem = itm.shuffled().shuffled()
        ),
        RestaurantName(
            name = "Mr Kacchi Ghar,SUST Gate",
            status = false,
            id = 2,
            resitem = itm.shuffled().shuffled().shuffled()
        )
    )
}