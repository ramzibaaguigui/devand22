package com.devfest.book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devfest.databinding.ActivityBookingTimeBinding

class BookingActivityTime : AppCompatActivity() {
    private lateinit var binding: ActivityBookingTimeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBookingTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}