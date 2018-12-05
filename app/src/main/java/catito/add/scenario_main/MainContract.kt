package catito.add.scenario_main

import catito.add.entities.Drink

interface MainContract {

    interface View{
        fun showList(drinks: List<Drink>)
        fun showMessage(mensagem: String)
        fun hideLoading()
        fun showLoading()
    }

    interface Presenter{
        fun onLoadList()
    }
}