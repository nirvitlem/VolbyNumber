package com.example.volbynumber

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import android.media.AudioManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService


class PhoneStateBR : BroadcastReceiver() {
    lateinit var audioManager: AudioManager
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
                    if (incomingNumber=="0543205519" || incomingNumber=="0506406883") {
                        audioManager =
                            getSystemService(context, AudioManager::class.java) as AudioManager
                        audioManager.ringerMode = AudioManager.RINGER_MODE_NORMAL
                        audioManager.setStreamVolume(AudioManager.STREAM_RING, 100, 0);
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE)
      //  }
    }

}


