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
import udacoding.test.assignmentudacoding.model.Covid

class AdapterCovid (val context: Context, private var covidList: ArrayList<Covid>):
    RecyclerView.Adapter<AdapterCovid.Holder>() {

    class Holder(view: View):RecyclerView.ViewHolder(view) {
        val tvProvince = view.findViewById<TextView>(R.id.tv_province)
        val tvPositive = view.findViewById<TextView>(R.id.tv_total_cases)
        val tvRecover = view.findViewById<TextView>(R.id.tv_total_recover)
        val tvDied = view.findViewById<TextView>(R.id.tv_total_died)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCovid.Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_covid, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterCovid.Holder, position: Int) {
        val itemCovidList: Covid = covidList[position]

        holder.tvProvince.text = itemCovidList.provinsi
        holder.tvPositive.text = itemCovidList.kasusPosi.toString()
        holder.tvRecover.text = itemCovidList.kasusSemb.toString()
        holder.tvDied.text = itemCovidList.kasusMeni.toString()

    }

    override fun getItemCount(): Int = covidList.size
}