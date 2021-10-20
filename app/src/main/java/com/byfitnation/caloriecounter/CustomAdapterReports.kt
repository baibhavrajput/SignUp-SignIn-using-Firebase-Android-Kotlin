package com.byfitnation.caloriecounter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapterReports (private  val mList: List<ItemsViewModelsReports>) : RecyclerView.Adapter<CustomAdapterReports.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_list_items_reports, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapterReports.ViewHolder, position: Int) {
        val ItemsViewModelsReports = mList[position]

        holder.nutrients.text = ItemsViewModelsReports.nutrients
        holder.plusMinus.text = ItemsViewModelsReports.plusMinus
        holder.total.text = ItemsViewModelsReports.total
        holder.goal.text = ItemsViewModelsReports.goal
    }
    override fun getItemCount(): Int {

        return  mList.size

    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

        val nutrients : TextView = itemView.findViewById(R.id.tvNutrientListItem)
        val total : TextView = itemView.findViewById(R.id.tvTotalListItem)
        val goal : TextView = itemView.findViewById(R.id.tvGoalListItem)
        val plusMinus : TextView = itemView.findViewById(R.id.tvPlusMinusListItem)
    }
}
