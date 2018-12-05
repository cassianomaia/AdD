package catito.add.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    val retrofit = Retrofit.Builder().baseUrl("https://thecocktaildb.com/api/json/v1/1/")
                                     .addConverterFactory(GsonConverterFactory.create())
                                     .build()

    fun createDrinkService() = retrofit.create(DrinkService::class.java)

}