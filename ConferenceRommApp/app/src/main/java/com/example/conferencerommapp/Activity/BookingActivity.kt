package com.example.conferencerommapp.Activity

import android.app.AppComponentFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.conferencerommapp.R

public class BookingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        Toast.makeText(applicationContext, "Hey It's Booking Activity",Toast.LENGTH_LONG).show()
    }
}