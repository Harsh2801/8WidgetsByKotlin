package com.example.android.harshgandhi

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Rate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate)

        var button: Button = findViewById(R.id.button)
        button.setOnClickListener {

            lateinit var js: JobScheduler
            lateinit var jobInfo: JobInfo
            js = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val cm = ComponentName(this, notify::class.java)
            val b = JobInfo.Builder(2, cm)
            b.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            b.setRequiresCharging(false)
            b.setRequiresDeviceIdle(false)
            jobInfo = b.build()
            js!!.schedule(jobInfo)
        }

    }
}