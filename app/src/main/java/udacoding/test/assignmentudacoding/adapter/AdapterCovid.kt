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
import udacoding.test.assignmentudacoding.model.Covid
import udacoding.test.assignmentudacoding.view.assignment3.DetailCovidActivity

class AdapterCovid (val context: Context, private var covidList: ArrayList<Covid>):
    RecyclerView.Adapter<AdapterCovid.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view) {
        val tvProvince = view.findViewById<TextView>(R.id.tv_province)
        val tvPositive = view.findViewById<TextView>(R.id.tv_total_cases)
        val tvRecover = view.findViewById<TextView>(R.id.tv_total_recover)
        val tvDied = view.findViewById<TextView>(R.id.tv_total_died)
        val constraintCovid = view.findViewById<ConstraintLayout>(R.id.constraint_covid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCovid.Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_covid, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterCovid.Holder, position: Int) {
        val itemCovidList: Covid = covidList[position]

        val kode_provinsi: String? = itemCovidList.kodeProvi.toString()
        holder.tvProvince.text = itemCovidList.provinsi
        holder.tvPositive.text = itemCovidList.kasusPosi.toString()
        holder.tvRecover.text = itemCovidList.kasusSemb.toString()
        holder.tvDied.text = itemCovidList.kasusMeni.toString()
        holder.constraintCovid.setOnClickListener {
            val intent = Intent(context, DetailCovidActivity::class.java)
            intent.putExtra("kode", kode_provinsi)
            intent.putExtra("provinsi", holder.tvProvince.text)
            intent.putExtra("positive", holder.tvPositive.text)
            intent.putExtra("recover", holder.tvRecover.text)
            intent.putExtra("died", holder.tvDied.text)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = covidList.size
}