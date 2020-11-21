package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Museum

class AdapterMuseum (val context: Context, private var museumList: ArrayList<Museum>):
    RecyclerView.Adapter<AdapterMuseum.Holder>(), Filterable{

    var museumListFilter = ArrayList<Museum>()
    init {
        museumListFilter = museumList
    }

    class Holder(view: View): RecyclerView.ViewHolder(view) {
        val museumName = view.findViewById<TextView>(R.id.tv_museum_name)
        val museumAddress = view.findViewById<TextView>(R.id.tv_address_museum)
        val museumCity = view.findViewById<TextView>(R.id.tv_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_museum, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterMuseum.Holder, position: Int) {
        val museum: Museum = museumListFilter[position]

        holder.museumName.text = museum.nama
        holder.museumAddress.text = museum.alamat_jalan
        holder.museumCity.text = museum.propinsi+", "+museum.kabupaten_kota
    }

    override fun getItemCount(): Int = museumListFilter.size

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): Filter.FilterResults {
                val querySearch = p0?.toString()?.toLowerCase()
                val filterResult = Filter.FilterResults()
                filterResult.values = if (querySearch==null || querySearch.isEmpty()){
                    museumList
                } else {
                    museumList.filter {
                        it.nama?.toLowerCase()!!.contains(querySearch)
                    }
                }
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                museumListFilter = p1?.values as ArrayList<Museum>
                notifyDataSetChanged()
            }

        }
    }
}