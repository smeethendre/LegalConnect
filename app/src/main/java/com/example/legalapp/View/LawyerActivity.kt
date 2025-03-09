package com.example.legalapp.View
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.legalapp.R

class LawyerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LawyerActivity", "LawyerActivity started")

        setContentView(R.layout.lawyer_layout) // Ensure this layout exists
    }
}
