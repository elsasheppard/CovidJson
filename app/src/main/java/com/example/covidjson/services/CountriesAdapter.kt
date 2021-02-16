package dev.bensalcie.retrofitest.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.covidjson.R
import com.example.covidjson.models.MyCountry
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.country_item.view.*

class CountriesAdapter(private val countriesList: List<MyCountry>) :RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // which layout are we using to display our items in the recycler view?
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return countriesList.size
    }

    // finding out which item to diaplay from the list based on the position and calling the bind function
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${countriesList.size} ")


        return holder.bind(countriesList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        // linking the individual object to the layout fields in our individual item view
        fun bind(country: MyCountry) {
            val name ="Cases :${country.cases.toString()}"
            itemView.tvTitle.text = country.country
            itemView.tvCases.text = name
            Picasso.get().load(country.countryInfo.flag).into(itemView.imageView)
        }

    }
}