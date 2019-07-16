package com.example.metro_prototype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*

class suggestions : AppCompatActivity() {
    val stations= arrayOf("Noida City Centre","Noida Golf Course",
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
    lateinit var suggestionslist:ListView
    lateinit var source:EditText
    lateinit var destination:EditText
    lateinit var adapter:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        stations.sort()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestions)
        suggestionslist = findViewById(R.id.suggestions_listview)
        source = findViewById(R.id.source_text)
        destination=findViewById(R.id.destination_text)
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stations)
        suggestionslist.adapter = adapter
        Log.d("Sorted", "Sorted list $")
        source.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (this@suggestions).adapter.filter.filter(s)
                suggestionslist.visibility=View.VISIBLE
            }
        })
        suggestionslist.setOnItemClickListener { parent, view, position, id ->
            val element = adapter.getItem(position)
            source.setText(element)
            Log.d("Prototype","v2 The source and destination is $source $destination")
            if (suggestionslist.visibility==View.VISIBLE) {
                suggestionslist.visibility = View.INVISIBLE
            }
        }
//        destination.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                (this@suggestions).adapter.filter.filter(s)
//                //suggestionslist.visibility=View.VISIBLE
//            }
//        })
//        suggestionslist.setOnItemClickListener { parent, view, position, id ->
//            val element2 = adapter.getItem(position)
//            destination.setText(element2)
//            Log.d("Prototype","The source and destination is $source $destination")
//            if (suggestionslist.visibility==View.VISIBLE) {
//                suggestionslist.visibility = View.INVISIBLE
//            }
//        }
        //Log.d("Prototype","The source and destination is $source $destination")
    }
}
