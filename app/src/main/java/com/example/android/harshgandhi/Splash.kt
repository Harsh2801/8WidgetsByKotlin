package com.example.android.harshgandhi

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.ProgressBar

class Splash : AppCompatActivity() {
    lateinit var pb: ProgressBar

    lateinit  var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        supportActionBar?.hide()
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        handler = Handler()
        handler.postDelayed({
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

        pb = findViewById(R.id.progressbar)
        pb.max = 1000
        ObjectAnimator.ofInt(pb,"progress",1000)
            .setDuration(3000)
            .start()

    }
}