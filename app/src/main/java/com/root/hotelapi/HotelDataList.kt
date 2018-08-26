package com.root.hotelapi

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HotelDataList {

    @SerializedName("places")
    @Expose
    var places: ArrayList<HotelDataClass>? = null
}