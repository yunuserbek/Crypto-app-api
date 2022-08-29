package com.example.cryptoappapi.api

import com.example.cryptoappapi.models.MarketModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("data-api/v3/cryptocurrency/listing?start=1&limit=500")
    suspend fun getMarketData():Response<MarketModel>
}