package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import udacoding.test.assignmentudacoding.view.Assignment2.DetailActivity
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Items

class AdapterListview(val context: Context, private val items: List<Items>?): BaseAdapter() {

    override fun getCount(): Int = items?.size?:0

    override fun getItem(p0: Int): Any {
        return items?.get(p0)?:0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, view: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_listview, parent, false)

        val image = view.findViewById<ImageView>(R.id.iv_item_list)
        val name = view.findViewById<TextView>(R.id.tv_item_list)
        val cl = view.findViewById<ConstraintLayout>(R.id.cl_item)

        val item = items?.get(p0)
        image.setImageResource(item?.image?:0)
        name.text = item?.nameItem
        cl.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", name.text)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

        return view
    }
}