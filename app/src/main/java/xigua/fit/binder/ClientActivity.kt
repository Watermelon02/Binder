package xigua.fit.binder

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import xigua.fit.binder.databinding.ActivityMainBinding

class ClientActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        val serviceConnection = object : ServiceConnection {

            override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
                val remoteInterface = Stub.asInterface(p1)
                remoteInterface.sendMessage("Connected")
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
            }
        }

        bindService(
            Intent(this, RemoteService::class.java),
            serviceConnection,
            Context.BIND_AUTO_CREATE
        )
    }
}