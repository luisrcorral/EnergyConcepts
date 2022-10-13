package mx.tec.energyconcepts

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PowerManager
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var powerReceiver  = powerStatus()
        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(powerReceiver, it)
        }

        var batteryReceiver  = batteryLevel()
        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(batteryReceiver, it)
        }

        var networkReceiver  = networkStatus()
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(networkReceiver, it)
        }

        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager
        val myWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "MyApp::MyTag")
        myWakeLock.acquire()
        //	..screen will stay on during this section..
        //	..screen will stay on during this section..
        myWakeLock.release()

    }
}