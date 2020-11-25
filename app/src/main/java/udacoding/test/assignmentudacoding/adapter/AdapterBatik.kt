package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Batik
import udacoding.test.assignmentudacoding.view.assignment3.DetailBatikActivity

class AdapterBatik (val context: Context, private var batikList: ArrayList<Batik>):
    RecyclerView.Adapter<AdapterBatik.Holder>(){

    class Holder(view: View):RecyclerView.ViewHolder(view) {
        val tvBatikName = view.findViewById<TextView>(R.id.tv_batik_name)
        val ivBatik = view.findViewById<ImageView>(R.id.iv_batik)
        val constraintItem = view.findViewById<ConstraintLayout>(R.id.constraint_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBatik.Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_batik, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterBatik.Holder, position: Int) {
        val itemBatikList: Batik = batikList[position]

        holder.tvBatikName.text = itemBatikList.nama_batik
        Glide.with(holder.itemView.context).load(itemBatikList.link_batik).into(holder.ivBatik)
        val makna:String = itemBatikList.makna_batik.toString()
        val link_image:String = itemBatikList.link_batik.toString()
        val low:String = itemBatikList.harga_rendah.toString()
        val high:String = itemBatikList.harga_tinggi.toString()
        holder.constraintItem.setOnClickListener {
            val intent = Intent(context, DetailBatikActivity::class.java)
            intent.putExtra("makna", makna)
            intent.putExtra("image", link_image)
            intent.putExtra("low", low)
            intent.putExtra("high", high)
            intent.putExtra("name", holder.tvBatikName.text)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = batikList.size
}