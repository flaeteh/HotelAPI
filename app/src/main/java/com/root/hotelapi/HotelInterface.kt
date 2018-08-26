package com.root.hotelapi

import retrofit2.Call
import retrofit2.http.GET

interface HotelInterface {

    @GET("http://sampleapi.us.openode.io/getPlaces?location=manila")
    fun myJSON(): Call<HotelDataList>
}