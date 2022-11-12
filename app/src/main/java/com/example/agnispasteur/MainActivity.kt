package com.example.agnispasteur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //para cambiar la pantalla del login a la bienvenida 1
        val btn: Button =  findViewById(R.id.btnSIGUIENTE)
        btn.setOnClickListener{
            val intent = Intent(this, MainActivity2bienvenida:: class.java )
            startActivity(intent)
        }
        //para cambiar la pantalla del login a la bienvenida 1

        //evento
        val analytics= FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "integracion de Firebase completa")
        analytics.logEvent("InitiScreen", bundle)

    }
}