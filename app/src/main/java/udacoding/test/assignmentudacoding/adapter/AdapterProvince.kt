package udacoding.test.assignmentudacoding.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Province
import udacoding.test.assignmentudacoding.view.assignment3.DetailCovidActivity

class AdapterProvince (val context: Context, private var provinceList: ArrayList<Province>):
        RecyclerView.Adapter<AdapterProvince.Holder>(){

    class Holder(view: View):RecyclerView.ViewHolder(view){
        val tvProvinceName = view.findViewById<TextView>(R.id.tv_province_name)!!
        val constraintItem = view.findViewById<ConstraintLayout>(R.id.constraint_item)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_province, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemProvinceList: Province = provinceList[position]
        val idProvinsi: String = itemProvinceList.id.toString()
        holder.tvProvinceName.text = itemProvinceList.nama
        holder.constraintItem.setOnClickListener {
            val snackbar =Snackbar.make(it, "Id provinsi : $idProvinsi, Nama provinsi : ${holder.tvProvinceName.text}", Snackbar.LENGTH_LONG)
                    .setAction("Tutup", null)
            snackbar.show()
        }
    }

    override fun getItemCount(): Int = provinceList.size
}