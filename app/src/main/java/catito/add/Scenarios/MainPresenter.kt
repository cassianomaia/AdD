package catito.add.Scenarios

import catito.add.Network.RetrofitInitializer
import catito.add.entities.DrinkList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View){

    fun onLoadList(){

        val drinkService = RetrofitInitializer().createDrinkService()

        val call = drinkService.getLista()

        call.enqueue(object: Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Você está sem internet D:")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if (response.body() != null) {
                    view.showList(response.body()!!.drinks)
                } else {
                    view.showMessage("Drinks não disponiveis.")
                }
            }
        })
    }

}