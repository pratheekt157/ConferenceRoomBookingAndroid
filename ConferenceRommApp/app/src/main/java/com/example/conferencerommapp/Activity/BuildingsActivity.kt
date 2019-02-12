package com.example.conferencerommapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.conferencerommapp.Helper.BuildingAdapter
import com.example.conferencerommapp.Model.Building
import com.example.conferencerommapp.R
import com.example.conferencerommapp.services.ConferenceService
import com.example.globofly.services.Servicebuilder
import kotlinx.android.synthetic.main.activity_building_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


public class BuildingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building_list)
        //loadBuildings()
    }

    override fun onResume() {
        super.onResume()
        loadBuildings()
    }

    private fun loadBuildings() {

        val conferenceService = Servicebuilder.buildService(ConferenceService::class.java)
        val requestCall : Call<List<Building>> = conferenceService.getBuildingList()
        requestCall.enqueue(object: Callback<List<Building>> {
            override fun onFailure(call: Call<List<Building>>, t: Throwable) {

                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Building>>, response: Response<List<Building>>) {
                if(response.isSuccessful) {
                    val buildingList: List<Building>? = response.body()
                    building_recycler_view.adapter = BuildingAdapter(buildingList!!)
                }
                else {
                    Toast.makeText(applicationContext,"Unable to Load the Buildings ",Toast.LENGTH_LONG).show()
                }

            }

        })
    }
}