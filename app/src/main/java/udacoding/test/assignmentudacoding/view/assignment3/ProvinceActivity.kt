package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import udacoding.test.assignmentudacoding.adapter.AdapterProvince
import udacoding.test.assignmentudacoding.databinding.ActivityProvinceBinding
import udacoding.test.assignmentudacoding.model.Province
import udacoding.test.assignmentudacoding.model.ResponseProvince
import udacoding.test.assignmentudacoding.network.ConfigNetwork
import java.util.ArrayList

class ProvinceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProvinceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ConfigNetwork.getProvince().getDataProvince().enqueue(object : Callback<ResponseProvince>{
            override fun onResponse(call: Call<ResponseProvince>, response: Response<ResponseProvince>) {
                if (response.isSuccessful){
                    binding.progressCircular.visibility = View.GONE
                    val provinsi = response.body()?.provinsi
                    showProvince(provinsi)
                }
            }

            override fun onFailure(call: Call<ResponseProvince>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun showProvince(provinsi: ArrayList<Province>?) {
        if (provinsi != null){
            binding.rvProvince.apply {
                layoutManager = GridLayoutManager(applicationContext, 2)
                adapter = AdapterProvince(applicationContext, provinsi)
            }
        }
    }
}