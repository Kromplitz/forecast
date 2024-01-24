package com.example.forecast

import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("/weather/Odessa")
    fun getForecast():Single<ForecastResponse>

}