package catito.add.Network

import catito.add.entities.DrinkList
import retrofit2.http.GET
import retrofit2.Call

interface DrinkService {

    //Função para obter todos os drinks alcoolicos
    @GET("filter.php?a=Alcoholic")
    fun getAlcoholic(): Call<DrinkList>
}
