package com.example.agnispasteur

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

@Suppress("UNREACHABLE_CODE")
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
        //setup
        setup()

    }

    private fun setup() {
        TODO("Not yet implemented")
        title = "Authentication"

        val btnsingup: Button =  findViewById(R.id.singbotton)
        btnsingup.setOnClickListener{

            val emailtext: EditText = findViewById(R.id.emailtext)
            val editTextTextPassword: EditText = findViewById(R.id.editTextTextPassword)

            if(emailtext.text.toString() != "" && editTextTextPassword.text.toString() != "") {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailtext.text.toString(),
                    editTextTextPassword.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            verindex(it.result?.user?.email?:"", ProviderType.BASIC)
                        }else{
                            alerta()
                        }
                }
            }
        }

        btnsingup.setOnClickListener{

            val emailtext: EditText = findViewById(R.id.emailtext)
            val editTextTextPassword: EditText = findViewById(R.id.editTextTextPassword)

            if(emailtext.text.toString() != "" && editTextTextPassword.text.toString() != "") {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(emailtext.text.toString(),
                    editTextTextPassword.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        verindex(it.result?.user?.email?:"", ProviderType.BASIC)
                    }else{
                        alerta()
                    }
                }
            }

        }

    }
    private fun alerta(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("se ha producido un error en la autenticacion del usuario")
        builder.setPositiveButton("aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    private fun verindex(email:String, provider: ProviderType){


        val homeindex: Intent  = Intent(this,MainActivity3Index::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeindex)
    }
}