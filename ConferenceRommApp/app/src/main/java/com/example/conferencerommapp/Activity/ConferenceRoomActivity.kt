package com.example.conferencerommapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.conferencerommapp.Helper.ConferenceRoomAdapter
import com.example.conferencerommapp.Model.ConferenceRoom
import com.example.conferencerommapp.R
import com.example.conferencerommapp.services.ConferenceService
import com.example.globofly.services.Servicebuilder
import kotlinx.android.synthetic.main.activity_conference_room.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class ConferenceRoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conference_room)

        var id: String = intent.getStringExtra("building_id")
        Toast.makeText(applicationContext, id, Toast.LENGTH_LONG).show()
        loadConferenceRoom(id.toInt())



    }

    override fun onResume() {
        super.onResume()
        loadConferenceRoom(1)
    }
    public fun loadConferenceRoom(id : Int) {
        val conferenceService = Servicebuilder.buildService(ConferenceService::class.java)
        val requestCall: Call<List<ConferenceRoom>> = conferenceService.getConferenceRoomList(id)
        requestCall.enqueue(object: Callback<List<ConferenceRoom>> {
            override fun onFailure(call: Call<List<ConferenceRoom>>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<ConferenceRoom>>, response: Response<List<ConferenceRoom>>) {
                if(response.isSuccessful) {
                   var conferenceRoomList =  response.body()
                    conference_recycler_view.adapter = ConferenceRoomAdapter(conferenceRoomList!!)
                }
                else {
                    Toast.makeText(applicationContext, "Unable to Load Conference Room", Toast.LENGTH_LONG).show()
                }

            }

        })
    }
}