package com.root.hotelapi

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.hotel_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    private var hotelList: ArrayList<HotelDataClass>? = null
    private var loading: ProgressDialog? = null
    private var recyclerView: RecyclerView? = null
    private var eAdapter: HotelAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = HotelObject.retrofitInstantiate

        showProgressDialog()
        api.myJSON().enqueue(object: Callback<HotelDataList> {
            override fun onResponse(call: Call<HotelDataList>, response: Response<HotelDataList>) {
                hotelList = response.body()!!.places
                recyclerView = findViewById(R.id.RecyclerView)
                eAdapter = HotelAdapter(hotelList!!, this@MainActivity)
                val eLayoutManager = LinearLayoutManager(applicationContext)
                recyclerView?.layoutManager = eLayoutManager
                recyclerView?.itemAnimator = DefaultItemAnimator()
                recyclerView?.adapter = eAdapter
                eAdapter!!.notifyDataSetChanged()
                dismissProgressDialog()
            }

            override fun onFailure(call: Call<HotelDataList>, t: Throwable) {
                loading?.dismiss()
            }
        })
    }
}
