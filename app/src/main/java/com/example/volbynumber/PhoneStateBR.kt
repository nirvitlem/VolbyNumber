package com.example.volbynumber

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.PhoneStateListener
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import androidx.core.app.NotificationCompat.getAction

class PhoneStateBR : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {


        Log.d("BroadcastReceiver","onReceive")
        val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            telephony.registerTelephonyCallback(
                context.mainExecutor,
                object : TelephonyCallback(), TelephonyCallback.CallStateListener {
                    override fun onCallStateChanged(state: Int) {
                        if (state==TelephonyManager.CALL_STATE_RINGING) {
                            Log.d("onCallStateChanged", "CALL_STATE_RINGING")
                            //Log.d("incomingNumber",telephony.)
                        }
                    }

                })
        } else */
        //{
            Log.d("onCallStateChanged","onReceive else")
            telephony.listen(object : PhoneStateListener() {
                override fun onCallStateChanged(state: Int, incomingNumber: String) {
                    super.onCallStateChanged(state, incomingNumber)
                    Log.d("onCallStateChanged",incomingNumber.toString())
                    println("incomingNumber : $incomingNumber")
                }
            }, PhoneStateListener.LISTEN_CALL_STATE)
      //  }
    }
}


