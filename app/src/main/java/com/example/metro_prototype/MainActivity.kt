package com.example.metro_prototype

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var source:AutoCompleteTextView
    lateinit var destination:AutoCompleteTextView
    val stations1= arrayOf("Noida City Centre","Noida Golf Course",
    "Botanical Garden",
    "Noida Sector 18",
    "Noida Sector 16",
    "Noida Sector 15",
    "New Ashok Nagar",
    "Mayur Vihar Extension",
    "Mayur Vihar - I",
    "Akshardham",
    "Yamuna Bank",
    "Indraprastha",
    "Pragati Maidan",
    "Mandi House",
    "Barakhambha Road",
    "Rajiv Chowk",
    "Ramakrishna Ashram Marg",
    "Jhandewalan",
    "Karol Bagh",
    "Rajendra Place",
    "Patel Nagar",
    "Shadipur",
    "Kirti Nagar",
    "Moti Nagar",
    "Ramesh Nagar",
    "Rajouri Garden",
    "Tagore Garden",
    "Subhash Nagar",
    "Tilak Nagar",
    "Janakpuri East",
    "Janakpuri West",
    "Uttam Nagar East",
    "Uttam Nagar West",
    "Nawada",
    "Dwarka Morh",
    "Dwarka",
    "Dwarka Sector 14",
    "Dwarka Sector 13",
    "Dwarka Sector 12",
    "Dwarka Sector 11",
    "Dwarka Sector 10",
    "Dwarka Sector 9",
    "Dwarka Sector 8","Dwarka Sector 21")

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        source=findViewById(R.id.Source)
        destination=findViewById(R.id.Destination)
        val adapter1=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stations1)
        val adapter2=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stations1)
        source.setAdapter(adapter1)
        destination.setAdapter(adapter2)
        button.setOnClickListener {
            val intent=Intent(this,suggestions::class.java)
            startActivity(intent)
            val final1=source.text.toString()
            val final2=destination.text.toString()
            val string="Your Source is $final1 \n and Destination station is $final2 "
            editText3.text=string
    }}
}
