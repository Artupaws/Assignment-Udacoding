package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Batik

class AdapterBatik (val context: Context, private var batikList: ArrayList<Batik>):
    RecyclerView.Adapter<AdapterBatik.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view) {
        val tvBatikName = view.findViewById<TextView>(R.id.tv_batik_name)
        val ivBatik = view.findViewById<ImageView>(R.id.iv_batik)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBatik.Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_batik, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterBatik.Holder, position: Int) {
        val itemBatikList: Batik = batikList[position]

        holder.tvBatikName.text = itemBatikList.nama_batik
        Glide.with(holder.itemView.context).load(itemBatikList.link_batik).into(holder.ivBatik)
    }

    override fun getItemCount(): Int = batikList.size
}