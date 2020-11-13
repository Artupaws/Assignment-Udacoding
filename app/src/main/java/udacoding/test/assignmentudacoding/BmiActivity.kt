package udacoding.test.assignmentudacoding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var et_name: EditText
    lateinit var et_weight_body: EditText
    lateinit var et_height_body: EditText
    lateinit var btn_count: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        et_name = findViewById(R.id.et_name)
        et_weight_body = findViewById(R.id.et_weight_body)
        et_height_body = findViewById(R.id.et_height_body)
        btn_count = findViewById(R.id.btn_count)
        btn_count.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_count ->
                countBodyMassIdeal()
        }
    }

    private fun countBodyMassIdeal() {
        if (et_name.text.isEmpty() || et_weight_body.text.isEmpty() || et_height_body.text.isEmpty()) {
            Toast.makeText(applicationContext, "Please complete the form", Toast.LENGTH_SHORT)
                .show()
        } else {
            val weight: Double = et_weight_body.text.toString().toDouble()
            val height: Double = et_weight_body.text.toString().toDouble()
            val name = et_name.text.toString()
            val weightBody = et_weight_body.text.toString()
            val heightBody = et_height_body.text.toString()
            val bmi = weight / (height * height * 0.0001)
            val dialogResult =
                LayoutInflater.from(this.applicationContext)
                    .inflate(R.layout.list_dialog_bmi, null)
            val et_name_dialog = dialogResult.findViewById<TextView>(R.id.et_name)
            val et_weight_body_dialog = dialogResult.findViewById<TextView>(R.id.et_weight_body)
            val et_height_body_dialog = dialogResult.findViewById<TextView>(R.id.et_height_body)
            val et_bmi_score = dialogResult.findViewById<TextView>(R.id.et_bmi_score)
            val builder = AlertDialog.Builder(this).setView(dialogResult).setTitle("Result")
            et_name_dialog.text = name
            et_weight_body_dialog.text = weightBody+"kg"
            et_height_body_dialog.text = heightBody+"cm"
            et_bmi_score.text = bmi.toString()
            val alertDialog = builder.show()
            alertDialog.setCancelable(true)
        }
    }

}
