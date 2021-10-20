package com.byfitnation.caloriecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.byfitnation.caloriecounter.databinding.ActivityReportsBinding

class ReportsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvReports.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)

        val data = ArrayList<ItemsViewModelsReports>()

        data.add(ItemsViewModelsReports("Calories" , "0","0","0"))
        data.add(ItemsViewModelsReports("Proteins" , "0","0","0"))
        data.add(ItemsViewModelsReports("Carbohydrates" , "0","0","0"))
        data.add(ItemsViewModelsReports("Fiber" , "0","0","0"))
        data.add(ItemsViewModelsReports("Sugar" , "0","0","0"))
        data.add(ItemsViewModelsReports("Fat" , "0","0","0"))
        data.add(ItemsViewModelsReports("Saturated Fat" , "0","0","0"))
        data.add(ItemsViewModelsReports("Polyunsaturated Fat" , "0","0","0"))
        data.add(ItemsViewModelsReports("Monounsaturated Fat" , "0","0","0"))
        data.add(ItemsViewModelsReports("Cholesterol" , "0","0","0"))
        data.add(ItemsViewModelsReports("Sodium" , "0","0","0"))
        data.add(ItemsViewModelsReports("Potassium" , "0","0","0"))

        val adapter = CustomAdapterReports(data)

        binding.rvReports.adapter = adapter

    }

}