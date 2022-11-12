package com.example.agnispasteur

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3Index : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity3_index)

//boton para ver la vista de bomba
        val btn1: Button =  findViewById(R.id.btbomba)
        btn1.setOnClickListener{
            val intent1= Intent(this, MainActivityBomba::class.java )
            startActivity(intent1)
        }

        //boton para la vista de colector
        val btn2: Button =  findViewById(R.id.btncolector)
        btn2.setOnClickListener{
            val intent2 = Intent(this, MainActivityColector :: class.java )
            startActivity(intent2)
        }
        //boton para la vista de ubicacion
        val btn3: Button =  findViewById(R.id.btnubicacion)
        btn3.setOnClickListener{
            val intent3= Intent(this, MainActivityUbicacion :: class.java )
            startActivity(intent3)
        }
        //boton para la vista de panel de control
        val btn4: Button =  findViewById(R.id.btnpaneldecontrol)
        btn4.setOnClickListener{
            val intent4= Intent(this, MainActivityPanel_de_control :: class.java )
            startActivity(intent4)
        }
        //boton para la vista de acumulador
        val btn5: Button =  findViewById(R.id.btnacumulador)
        btn5.setOnClickListener{
            val intent5 = Intent(this, MainActivityAcumulador :: class.java )
            startActivity(intent5)
        }
        //boton para la vista de temperatura
        val btn6: Button =  findViewById(R.id.btntemperatura)
        btn6.setOnClickListener{
            val intent6 = Intent(this, MainActivityTemperatura :: class.java )
            startActivity(intent6)
        }
    }

}