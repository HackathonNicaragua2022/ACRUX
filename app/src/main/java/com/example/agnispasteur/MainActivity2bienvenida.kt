package com.example.agnispasteur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.bienvenida1)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2bienvenida)

        //para cambiar la pantalla del login a la bienvenida 2
        val btn: Button =  findViewById(R.id.btnsiguientebienvenida)
        btn.setOnClickListener{
            val intent= Intent(this, MainActivity3Index :: class.java )
            startActivity(intent)
        }
        //para cambiar la pantalla del login a la bienvenida 2

    }
}