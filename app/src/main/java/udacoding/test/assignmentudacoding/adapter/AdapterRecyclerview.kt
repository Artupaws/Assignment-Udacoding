package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import udacoding.test.assignmentudacoding.DetailActivity
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Items

class AdapterRecyclerview (val context: Context, private val items: ArrayList<Items>):
        RecyclerView.Adapter<AdapterRecyclerview.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRecyclerview.Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterRecyclerview.Holder, position: Int) {
        val itemsList: Items = items[position]

        holder.tvItemList.text = itemsList.nameItem
        holder.ivItemList.setImageResource(itemsList.image)
        holder.clItem.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("name", holder.tvItemList.text.toString())
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = items.size

    class Holder(view:View):RecyclerView.ViewHolder(view) {
        val tvItemList = view.findViewById<TextView>(R.id.tv_item_list)
        val ivItemList = view.findViewById<ImageView>(R.id.iv_item_list)
        val clItem = view.findViewById<ConstraintLayout>(R.id.cl_item)
    }

}