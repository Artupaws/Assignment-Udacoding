package udacoding.test.assignmentudacoding.view.Assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.view.mainmenu.MainMenuActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var et_username:EditText
    private lateinit var et_password:EditText
    private lateinit var btn_login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        btn_login = findViewById(R.id.btn_login)
        btn_login.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.btn_login -> loginCheck()
        }
    }

    private fun loginCheck(){
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        when {
            username.isEmpty() -> {
                et_username.error = "Masukan username!"
            }
            password.isEmpty() -> {
                et_password.error = "Masukan password!"
            }
            else -> {
                val intent = Intent(applicationContext, MainMenuActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finishAffinity()
            }
        }
    }

}