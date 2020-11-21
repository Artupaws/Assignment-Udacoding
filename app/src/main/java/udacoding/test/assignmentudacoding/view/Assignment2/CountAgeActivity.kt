package udacoding.test.assignmentudacoding.view.Assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import udacoding.test.assignmentudacoding.R
import java.util.*

class CountAgeActivity : AppCompatActivity() {

    val thisYear = Calendar.getInstance().get(Calendar.YEAR)
    lateinit var et_birth_year: EditText
    lateinit var tv_current_age: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_age)

        et_birth_year = findViewById(R.id.et_birth_year)
        tv_current_age = findViewById(R.id.tv_current_age)

        et_birth_year.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                when {
                    p0?.length!! < 4 -> {
                        Toast.makeText(applicationContext, "Please insert your birth year", Toast.LENGTH_SHORT).show()
                    }
                    p0.length == 4 -> {
                        val currentAge = thisYear - p0.toString().toInt()
                        tv_current_age.text = currentAge.toString()
                    }
                    else -> {
                        tv_current_age.text = ""
                    }
                }
            }
        })
    }

}