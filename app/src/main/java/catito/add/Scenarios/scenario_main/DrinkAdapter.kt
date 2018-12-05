package catito.add.Scenarios.scenario_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import catito.add.R
import catito.add.Utils.GlideApp
import catito.add.entities.Drink
import kotlinx.android.synthetic.main.drink_item.view.*

class DrinkAdapter (val context: Context, val drinks: List<Drink>): RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var ItemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int)-> Unit)){
        this.ItemClickListener = clique
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], ItemClickListener)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?) {

            GlideApp.with(context)
                .load(drink.strDrinkThumb)
                .centerCrop()
                .into(itemView.imgDrink)

            itemView.txtDrink.text = drink.strDrink

            if(itemClickListener != null){
                itemView.setOnClickListener{
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }
    }
}