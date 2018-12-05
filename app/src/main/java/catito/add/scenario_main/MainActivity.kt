package catito.add.scenario_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import catito.add.R
import catito.add.entities.Drink
import catito.add.scenario_drink.DrinkActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        const val DRINK_ACTIVITY = "drinkActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter= MainPresenter(this)
        presenter.onLoadList()
    }


    override fun showList(drinks: List<Drink>){
        val adapter = DrinkAdapter(this, drinks)

        adapter.setOnItemClickListener { position ->
            showLoading()
            val presenter: MainContract.Presenter = MainPresenter(this)
            presenter.onClickDrink(drinks[position])
        }

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }

    override fun startDrinkActivity(drink: Drink) {
        val drinkActivity = Intent(this, DrinkActivity::class.java)
        drinkActivity.putExtra(DRINK_ACTIVITY, drink)
        startActivity(drinkActivity)
    }

    override fun showMessage(mensagem: String){
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        hideLoading()
    }
}
