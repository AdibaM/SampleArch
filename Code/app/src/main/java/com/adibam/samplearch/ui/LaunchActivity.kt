package com.adibam.samplearch.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adibam.samplearch.R

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launch_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    LaunchFragment.newInstance()
                )
                .commitNow()
        }
    }

}
