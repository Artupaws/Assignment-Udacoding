package udacoding.test.assignmentudacoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import udacoding.test.assignmentudacoding.adapter.AdapterListview
import udacoding.test.assignmentudacoding.model.Items

class ListViewActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.lv)

        val listAvenger = ArrayList<Items>()
        listAvenger.add(Items("Iron Man", R.drawable.ironman))
        listAvenger.add(Items("Spider Man", R.drawable.spiderman))
        listAvenger.add(Items("Hawk Eye", R.drawable.hawkeye))
        listAvenger.add(Items("Hulk", R.drawable.hulk))
        listAvenger.add(Items("Dr Strange", R.drawable.strange))
        listAvenger.add(Items("Wanda", R.drawable.wanda))
        listAvenger.add(Items("Vision", R.drawable.vision))
        listAvenger.add(Items("Black Panther", R.drawable.blackphanter))
        listAvenger.add(Items("Black Widow", R.drawable.blackwidow))
        listAvenger.add(Items("Ant Man", R.drawable.antman))
        listAvenger.add(Items("Rocket Raccoon", R.drawable.rocketracoon))
        listAvenger.add(Items("Groot", R.drawable.groot))

        val adapter = AdapterListview(this, listAvenger)
        listView.adapter = adapter

    }
}