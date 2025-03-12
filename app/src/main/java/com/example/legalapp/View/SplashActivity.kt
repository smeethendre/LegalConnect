package com.example.legalapp.View

    import android.content.Intent
    import android.os.Bundle
    import android.os.Handler
    import android.os.Looper
    import androidx.appcompat.app.AppCompatActivity
    import com.example.legalapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LawyerActivity::class.java)) // Change from MainActivity to LawyerActivity
            finish()
        }, 2000)
    }
}
