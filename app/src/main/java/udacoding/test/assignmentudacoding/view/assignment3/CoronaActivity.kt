package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udacoding.test.assignmentudacoding.adapter.AdapterCovid
import udacoding.test.assignmentudacoding.databinding.ActivityCoronaBinding
import udacoding.test.assignmentudacoding.model.Covid
import udacoding.test.assignmentudacoding.model.ResponseCorona
import udacoding.test.assignmentudacoding.network.ConfigNetwork
import java.util.ArrayList

class CoronaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoronaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoronaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ConfigNetwork.getCovid().getDataCovid().enqueue(object : Callback<ResponseCorona>{
            override fun onResponse(call: Call<ResponseCorona>, response: Response<ResponseCorona>) {
                if (response.isSuccessful){
                    binding.progressCircular.visibility = View.GONE
                    val data = response.body()?.data
                    showDataCovid(data)
                }
            }

            override fun onFailure(call: Call<ResponseCorona>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun showDataCovid(data: ArrayList<Covid>?) {
        if (data !=null){
            binding.rvCovid.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = AdapterCovid(applicationContext, data)
            }
        }
    }
}