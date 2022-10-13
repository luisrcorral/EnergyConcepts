package mx.tec.energyconcepts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.Toast


class powerStatus : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val plugged = intent?.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)

        if (plugged == BatteryManager.BATTERY_PLUGGED_AC)
            Toast.makeText(context, "Device is Plugged to AC", Toast.LENGTH_LONG).show()
        else if (plugged == BatteryManager.BATTERY_PLUGGED_USB)
            Toast.makeText(context, "Device is Plugged to USB", Toast.LENGTH_LONG).show()
        else if (plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS)
            Toast.makeText(context, "Device is Plugged to Wireless Charger", Toast.LENGTH_LONG).show()
        else
            Toast.makeText(context, "Device is not Plugged", Toast.LENGTH_LONG).show()
    }
}
