package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.R
import udacoding.test.assignmentudacoding.databinding.ActivityDetailBatikBinding

class DetailBatikActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailBatikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBatikBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val makna:String = intent.extras?.get("makna").toString()
        val low:String = intent.extras?.get("low").toString()
        val high:String = intent.extras?.get("high").toString()
        val url_batik:String = intent.extras?.get("image").toString()
        val name:String = intent.extras?.get("name").toString()

        binding.btnClose.setOnClickListener(this)
        binding.tvNameBatik.text = name
        binding.tvDescBatik.text = makna
        binding.tvHighCost.text = "Rp $high"
        binding.tvLowCost.text = "Rp $low"
        Glide.with(applicationContext).load(url_batik).into(binding.ivBatik)

    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            udacoding.test.assignmentudacoding.R.id.btn_close -> {
                onBackPressed()
            }
        }
    }
}