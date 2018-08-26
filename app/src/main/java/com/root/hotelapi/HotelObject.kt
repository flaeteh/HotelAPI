package com.root.hotelapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HotelObject {

    private const val ROOT_URL = "http://sampleapi.us.openode.io/"

    private val retrofitInstance: Retrofit
    get() = Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val retrofitInstantiate: HotelInterface
    get() = retrofitInstance.create<HotelInterface>(HotelInterface::class.java)
}