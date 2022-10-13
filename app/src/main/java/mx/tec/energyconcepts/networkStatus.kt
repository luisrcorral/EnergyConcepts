package mx.tec.energyconcepts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi


class networkStatus : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context?, intent: Intent?) {

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = networkInfo?.isConnectedOrConnecting == true

        val network = connectivityManager.activeNetwork
        val activeNetwork = connectivityManager.getNetworkCapabilities(network)

        if (isConnected) {
           Toast.makeText(context, "Device online", Toast.LENGTH_LONG).show()

            if (activeNetwork != null) {
                if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Toast.makeText(context, "Device on Wifi", Toast.LENGTH_LONG).show()
                }
                if (activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Toast.makeText(context, "Device on Cellular Network", Toast.LENGTH_LONG).show()
                }
            }
        }
        else {
            Toast.makeText(context, "Device offline", Toast.LENGTH_LONG).show()
        }

    }

}







