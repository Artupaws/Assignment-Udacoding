package udacoding.test.assignmentudacoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import udacoding.test.assignmentudacoding.adapter.AdapterRecyclerview
import udacoding.test.assignmentudacoding.model.Items

class RecyclerviewActivity : AppCompatActivity() {

    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recyclerview = findViewById(R.id.recyclerview)

        val list = arrayListOf(
                Items(nameItem = "Tesla Model S", R.drawable.tesla_model_s),
                Items(nameItem = "Tesla Model 3", R.drawable.tesla_model_3),
                Items(nameItem = "Tesla Model X", R.drawable.tesla_model_x),
                Items(nameItem = "Tesla Roadster", R.drawable.tesla_roadster),
                Items(nameItem = "Tesla Cybertruck", R.drawable.tesla_cybertruck),
        )

        val itemsAdapter = AdapterRecyclerview(applicationContext,list)

        recyclerview.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = itemsAdapter
        }

    }
}