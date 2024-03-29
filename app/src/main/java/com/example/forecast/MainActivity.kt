package com.example.forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todayTextview = findViewById<TextView>(R.id.todayTextview)

        val weatherButton = findViewById<Button>(R.id.weatherButton)

        weatherButton.setOnClickListener {

        val apiClient = APIClient.client.create(APIInterface::class.java)
            apiClient.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ( {
                    todayTextview.text = "${it.temperature} ${it.wind} ${it.description}"



                    //forecastTextview.text = "${it.forecast}"

                }, {
                    Toast.makeText(this, "Error ${it.message}", Toast.LENGTH_LONG).show()
                }
                )
            

        }
    }
}

