package udacoding.test.assignmentudacoding.view.mainmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.databinding.ActivityMainMenuBinding
import udacoding.test.assignmentudacoding.view.Assignment2.AssignmentWeek2Activity
import udacoding.test.assignmentudacoding.view.assignment3.AssignmentWeek3Activity

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainMenuBinding
    private var username: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.extras?.get("username").toString()
        binding.tvUsername.text = username
        binding.btnAssignmentWeek2.setOnClickListener(this)
        binding.btnAssignmentWeek3.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_assignment_week2 -> {
                intent = Intent(applicationContext, AssignmentWeek2Activity::class.java)
                startActivity(intent)
            }
            R.id.btn_assignment_week3 ->{
                intent = Intent(applicationContext, AssignmentWeek3Activity::class.java)
                startActivity(intent)
            }
        }
    }

}