package com.example.conferencerommapp.Helper

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.conferencerommapp.Activity.BookingActivity
import com.example.conferencerommapp.Activity.ConferenceRoomActivity
import com.example.conferencerommapp.Model.Building
import com.example.conferencerommapp.Model.ConferenceRoom
import com.example.conferencerommapp.R


class ConferenceRoomAdapter(private val conferenceRoomList: List<ConferenceRoom>) : androidx.recyclerview.widget.RecyclerView.Adapter<ConferenceRoomAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

		val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_conference_room, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		holder.conferenceRoom = conferenceRoomList[position]

		holder.txvRoom.text = conferenceRoomList[position].conf_name
		//Log.i("################",conferenceRoomList[position].conf_name);
		holder.txvRoomCapacity.text = conferenceRoomList[position].conf_capacity
		var id = conferenceRoomList[position].building_id
		holder.itemView.setOnClickListener { v ->
			val context = v.context
			val intent = Intent(context, BookingActivity::class.java)
			//intent.putExtra("building_id", id)
			//intent.putExtra("building_id", id)
			context.startActivity(intent)
		}
	}

	override fun getItemCount(): Int {
		return conferenceRoomList.size
	}

	class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

		val txvRoom: TextView = itemView.findViewById(R.id.txv_room)
		val txvRoomCapacity: TextView = itemView.findViewById(R.id.txv_room_capacity)
		var conferenceRoom: ConferenceRoom? = null

	//	override fun toString(): String {
	//		return """${super.toString()} '${txvRoom.text}'"""
	//	}
	}
}
