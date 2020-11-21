package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Province

class AdapterProvince (val context: Context, private var provinceList: ArrayList<Province>):
        RecyclerView.Adapter<AdapterProvince.Holder>(){

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvProvinceName = view.findViewById<TextView>(R.id.tv_province_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_province, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemProvinceList: Province = provinceList[position]

        holder.tvProvinceName.text = itemProvinceList.nama
    }

    override fun getItemCount(): Int = provinceList.size
}