package com.devfest.testHistory

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devfest.R
import com.devfest.model.dataClasses.MyTestItem

class TestDetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_detail)

        val rvMyTestDetail = findViewById<RecyclerView>(R.id.rv_test_detail)
        rvMyTestDetail.layoutManager = LinearLayoutManager(this)

        val data = listOf(
            "hb" , "Glucemie" , "Git" , "Etc.."
        )

        val adapter = TestDetailAdapter(data)
        rvMyTestDetail.adapter = adapter

    }
}