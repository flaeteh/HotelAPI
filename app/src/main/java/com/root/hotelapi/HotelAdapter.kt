package com.root.hotelapi

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.root.hotelapi.R.id.button
import kotlinx.android.synthetic.main.hotel_list.view.*
import org.jetbrains.anko.find

class HotelAdapter(
    private val hotelList: List<HotelDataClass>, context: Context) : RecyclerView.Adapter<HotelAdapter.ViewHolder>() {

    private var context : Context? = context
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context)
                .inflate(R.layout.hotel_list, parent, false)

        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var hotelname: TextView? = null
        var hotelimg: ImageView? = null
        var navigate: Button? = null

        init {
            this.navigate = view?.findViewById<Button>(R.id.button)
            this.hotelname = view?.findViewById(R.id.hotelname)
            this.hotelimg = view?.findViewById(R.id.hotelimg)
        }

    }

    override fun getItemCount() : Int {
        return hotelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  {
        var place = hotelList[position]
        Glide.with(holder?.itemView.context)
                .load(place.photo)
                .into(holder?.hotelimg!!)

        holder?.hotelname?.text = place.name
        holder?.navigate?.setOnClickListener {
            openMaps(place.lat!!, place.long!!, place.name!!)
        }
    }


    private fun openMaps (lat: Double, long: Double, name: String) {
        //call longitude and latitude from api
        val strUri = "http://maps.google.com/maps?q=loc:$lat,$long($name)"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(strUri))
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity")
        context?.startActivity(intent)
    }
}