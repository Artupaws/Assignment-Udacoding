package udacoding.test.assignmentudacoding.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.model.Museum
import udacoding.test.assignmentudacoding.view.assignment3.DetailMuseumActivity

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
        val constraintItem = view.findViewById<ConstraintLayout>(R.id.constraint_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item_museum, parent, false)
        return Holder(v)
    }

    override fun onBindViewHolder(holder: AdapterMuseum.Holder, position: Int) {
        val museum: Museum = museumListFilter[position]

        val kode_pengelolaan: String = museum.kode_pengelolaan.toString()
        val alamat_jalan: String = museum.alamat_jalan.toString()
        val kecamatan: String = museum.kecamatan.toString()
        val kota:String = museum.kabupaten_kota.toString()
        val provinsi:String = museum.propinsi.toString()
        val sumber_dana:String = museum.sumber_dana.toString()
        val tahun_berdiri:String = museum.tahun_berdiri.toString()
        val pengelola:String = museum.pengelola.toString()
        val tipe:String = museum.tipe.toString()
        holder.museumName.text = museum.nama
        holder.museumAddress.text = museum.alamat_jalan
        holder.museumCity.text = museum.propinsi+", "+museum.kabupaten_kota
        holder.constraintItem.setOnClickListener {
            val intent = Intent(context, DetailMuseumActivity::class.java)
            intent.putExtra("kode", kode_pengelolaan)
            intent.putExtra("alamat", alamat_jalan)
            intent.putExtra("kecamatan", kecamatan)
            intent.putExtra("kota", kota)
            intent.putExtra("provinsi", provinsi)
            intent.putExtra("dana", sumber_dana)
            intent.putExtra("berdiri", tahun_berdiri)
            intent.putExtra("pengelola", pengelola)
            intent.putExtra("tipe", tipe)
            intent.putExtra("nama", holder.museumName.text)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
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