package com.example.forecast

import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("/weather/Lviv")
    fun getForecast():Single<ForecastResponse>

}