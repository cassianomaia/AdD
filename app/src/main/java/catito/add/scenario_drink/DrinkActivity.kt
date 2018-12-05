package catito.add.scenario_drink

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import catito.add.R
import catito.add.Utils.GlideApp
import catito.add.entities.Drink
import kotlinx.android.synthetic.main.activity_drink.*

class DrinkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drink)

        if(intent.extras != null){
            val drink: Drink = intent.getSerializableExtra("drinkActivity") as Drink

            txtDrink.text = drink.strDrink
            txtCategoria.text = drink.strCategory
            txtIBA.text = drink.strIBA
            txtGlass.text = drink.strGlass
            txtInstructions.text = drink.strInstructions

            GlideApp.with(this)
                .load(drink.strDrinkThumb)
                .centerCrop()
                .into(imgDrink)
        }
    }
}
