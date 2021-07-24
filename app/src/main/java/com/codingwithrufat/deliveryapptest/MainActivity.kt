package com.codingwithrufat.deliveryapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView: TextView = findViewById(R.id.hello)
        val provider = ViewModelProvider(this).get(ViewModelMain::class.java)

        provider.getDeliveryData()

        provider.getData().observe(this,
            { t ->
                textView.text = t?.get(0)?.title
            })

    }
}