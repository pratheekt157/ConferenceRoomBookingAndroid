package com.example.conferencerommapp.Helper

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.conferencerommapp.Activity.ConferenceRoomActivity
import com.example.conferencerommapp.Model.Building
import com.example.conferencerommapp.R


class BuildingAdapter(private val buildingList: List<Building>) : androidx.recyclerview.widget.RecyclerView.Adapter<BuildingAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

		val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
		return ViewHolder(view)
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {

		holder.building = buildingList[position]
		holder.txvBuilding.text = buildingList[position].building_name
		var id = buildingList[position].building_id
		holder.itemView.setOnClickListener { v ->
			val context = v.context
			val intent = Intent(context, ConferenceRoomActivity::class.java)
			//intent.putExtra("building_id", id)
			intent.putExtra("building_id", id)
			context.startActivity(intent)
		}
	}

	override fun getItemCount(): Int {
		return buildingList.size
	}

	class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

		val txvBuilding: TextView = itemView.findViewById(R.id.txv_building)
		var building: Building? = null

		override fun toString(): String {
			return """${super.toString()} '${txvBuilding.text}'"""
		}
	}
}
