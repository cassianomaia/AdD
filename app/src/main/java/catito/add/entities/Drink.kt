package catito.add.entities

import java.io.Serializable

data class Drink(val strDrink: String,
                 val strDrinkThumb: String,
                 val idDrink: String,
                 val strCategory: String,
                 val strIBA: String,
                 val strGlass: String,
                 val strInstructions: String): Serializable