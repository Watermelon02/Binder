package xigua.fit.binder

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.util.Log
import android.view.SurfaceControl
import xigua.fit.binder.aidl.AidlInterface

class RemoteService : Service() {
    private lateinit var myBinder: Binder
    override fun onCreate() {
        super.onCreate()
        /*myBinder = object :Stub(){
            override fun sendMessage(string: String) {
                Log.d("testTag", "sendMessage: $string")
            }
        }*/
        myBinder = object : AidlInterface.Stub() {
            override fun print(msg: String?) {
                Log.d("testTag", "print: $msg")
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        return myBinder
    }
}