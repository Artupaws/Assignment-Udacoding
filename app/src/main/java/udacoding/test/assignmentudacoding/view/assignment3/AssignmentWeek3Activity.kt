package udacoding.test.assignmentudacoding.view.assignment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.databinding.ActivityAssignmentWeek3Binding

class AssignmentWeek3Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAssignmentWeek3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignmentWeek3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarWeek3.title = "Assignment Week 3"
        binding.btnTask1.setOnClickListener(this)
        binding.btnTask2.setOnClickListener(this)
        binding.btnTask3.setOnClickListener(this)
        binding.btnTask4.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_task1 -> {
                intent = Intent(applicationContext, BatikActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task2 -> {
                intent = Intent(applicationContext, MuseumActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task3 -> {
                intent = Intent(applicationContext, ProvinceActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_task4 -> {
                intent = Intent(applicationContext, CoronaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}