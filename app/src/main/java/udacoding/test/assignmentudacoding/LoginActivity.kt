package udacoding.test.assignmentudacoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

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
        if (username.isEmpty()){
            et_username.setError("Masukan username!")
        } else if (password.isEmpty()){
            et_password.setError("Masukan password!")
        } else {
            val intent = Intent(applicationContext, AssignmentActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
            finishAffinity()
        }
    }

}