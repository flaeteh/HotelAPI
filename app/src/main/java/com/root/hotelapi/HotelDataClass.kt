package com.root.hotelapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HotelDataClass {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("photo")
    @Expose
    var photo: String? = null

    @SerializedName("long")
    @Expose
    var long: Double? = null

    @SerializedName("lat")
    @Expose
    var lat: Double? = null

}