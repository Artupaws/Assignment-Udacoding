package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udacoding.test.assignmentudacoding.adapter.AdapterBatik
import udacoding.test.assignmentudacoding.databinding.ActivityBatikBinding
import udacoding.test.assignmentudacoding.model.Batik
import udacoding.test.assignmentudacoding.model.ResponseBatik
import udacoding.test.assignmentudacoding.network.ConfigNetwork

class BatikActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBatikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBatikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ConfigNetwork.getBatik().getDataBatik().enqueue(object : Callback<ResponseBatik>{
            override fun onResponse(call: Call<ResponseBatik>, response: Response<ResponseBatik>) {
                if (response.isSuccessful){
                    binding.progressCircular.visibility = View.GONE
                    val hasil = response.body()?.hasil
                    Log.d("jumlah", hasil?.size.toString())
                    showBatik(hasil)
                }
            }

            override fun onFailure(call: Call<ResponseBatik>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun showBatik(hasil: ArrayList<Batik>?) {
        if (hasil != null) {
            AdapterBatik(applicationContext, hasil)
            binding.rvBatik.adapter = AdapterBatik(applicationContext, hasil)
        }
    }
}