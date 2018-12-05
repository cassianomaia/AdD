package catito.add.Network

import catito.add.entities.Drink
import catito.add.entities.DrinkList
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface DrinkService {

    //Função para obter todos os drinks alcoolicos
    @GET("filter.php?a=Alcoholic")
    fun getLista(): Call<DrinkList>

    //Função para obter um drink através do ID
    @GET("lookup.php?i=")
    fun getDrinkID(@Query("i")query: String): Call<DrinkList>
}
