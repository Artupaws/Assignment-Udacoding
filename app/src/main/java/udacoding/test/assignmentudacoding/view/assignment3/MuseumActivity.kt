package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udacoding.test.assignmentudacoding.adapter.AdapterMuseum
import udacoding.test.assignmentudacoding.databinding.ActivityMuseumBinding
import udacoding.test.assignmentudacoding.model.Museum
import udacoding.test.assignmentudacoding.model.ResponseMuseum
import udacoding.test.assignmentudacoding.network.ConfigNetwork
import java.util.ArrayList

class MuseumActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMuseumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuseumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ConfigNetwork.getMuseum().getDataMuseum().enqueue(object : Callback<ResponseMuseum>{
            override fun onResponse(call: Call<ResponseMuseum>, response: Response<ResponseMuseum>) {
                if (response.isSuccessful){
                    val data = response.body()?.data
                    Log.d("isinyga", data!!.size.toString())
                    binding.progressCircular.visibility = View.GONE
                    showMuseum(data)
                }
            }

            override fun onFailure(call: Call<ResponseMuseum>, t: Throwable) {
                val snack = Snackbar.make(binding.rvMuseum, "Sorry, failed to get list museum :(", Snackbar.LENGTH_INDEFINITE)
                snack.setAction("DISMISS") {
                    snack.dismiss()
                    onBackPressed()
                }
                snack.show()
            }
        })

        binding.etSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                (binding.rvMuseum.adapter as AdapterMuseum).filter.filter(p0)
                (binding.rvMuseum.adapter as AdapterMuseum).notifyDataSetChanged()
                return true
            }

        })

    }

    private fun showMuseum(data: ArrayList<Museum>?) {
        if (data != null){
//            AdapterMuseum(applicationContext, data)
            binding.rvMuseum.apply {
                layoutManager = GridLayoutManager(applicationContext, 2)
                adapter = AdapterMuseum(applicationContext, data)
            }
        }
    }
}