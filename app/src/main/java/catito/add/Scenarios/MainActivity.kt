package catito.add.Scenarios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import catito.add.R
import catito.add.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter = MainPresenter(this)
    }


    fun showList(drinks: List<Drink>){
        val adapter = DrinkAdapter(this, drinks)

        rvDrinks.adapter = adapter
        rvDrinks.layoutManager = LinearLayoutManager(this)
    }

    fun showMessage(mensagem: String){
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
    }

    fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }
}
