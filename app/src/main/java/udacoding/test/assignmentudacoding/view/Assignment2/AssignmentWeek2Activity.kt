package udacoding.test.assignmentudacoding.view.Assignment2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import udacoding.test.assignmentudacoding.R

class AssignmentWeek2Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment_week2)

        btn1 = findViewById(R.id.btn_task1)
        btn2 = findViewById(R.id.btn_task2)
        btn3 = findViewById(R.id.btn_task3)
        btn4 = findViewById(R.id.btn_task4)
        btn5 = findViewById(R.id.btn_task5)
        toolbar = findViewById(R.id.toolbar_week3)

        btn3.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        toolbar.title = "Assignment Week 2"

    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.btn_task3 -> {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }

            R.id.btn_task2 -> {
                val intent = Intent(applicationContext, CountAgeActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_task4 -> {
                val intent = Intent(applicationContext, RecyclerviewActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_task5 ->{
                val intent = Intent(applicationContext, ListViewActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_task1 ->{
                val intent = Intent(applicationContext, BmiActivity::class.java)
                startActivity(intent)
            }

        }
    }
}