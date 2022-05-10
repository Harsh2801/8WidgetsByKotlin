package com.example.android.harshgandhi

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class notify : JobService() {
    var nm: NotificationManager? = null
    val id = "mynotification"

    @RequiresApi(api = Build.VERSION_CODES.O)
    override fun onStartJob(jobParameters: JobParameters): Boolean {
        nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val i = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(
            this,
            1, i, PendingIntent.FLAG_ONE_SHOT
        )
        val builder = NotificationCompat.Builder(this, channal_ID)
        builder.setSmallIcon(R.drawable.ic_launcher_background)
        builder.setContentTitle("RATING")
        builder.setContentText("Thank you for RATING US")
        // builder.setLights(Color.RED, 3000, 3000);
        builder.color = resources.getColor(R.color.purple_500)
        //  builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        builder.setContentIntent(pi)
        val importance = NotificationManager.IMPORTANCE_HIGH
        val name = "My Channel Name"
        val notificationChannel = NotificationChannel(channal_ID, name, importance)
        builder.setAutoCancel(true)
        nm!!.notify(idd, builder.build())
        nm!!.createNotificationChannel(notificationChannel)
        return true
    }

    override fun onStopJob(jobParameters: JobParameters): Boolean {
        return false
    }

    companion object {
        const val channal_ID = "My Channel Id"
        const val idd = 1
    }
}