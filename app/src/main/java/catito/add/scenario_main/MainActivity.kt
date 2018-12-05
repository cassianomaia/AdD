package catito.add.scenario_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import catito.add.R
import catito.add.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter= MainPresenter(this)
        presenter.onLoadList()
    }


    override fun showList(drinks: List<Drink>){
        val adapter = DrinkAdapter(this, drinks)

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
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
