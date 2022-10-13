package mx.tec.energyconcepts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast

class batteryLevel : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val level = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
        Toast.makeText(context, "Battery Level: " + level.toString() + "%", Toast.LENGTH_LONG).show()

    }
}