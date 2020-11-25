package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.databinding.ActivityDetailCovidBinding

class DetailCovidActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kode:String = intent.extras?.get("kode").toString()
        val provinsi:String = intent.extras?.get("provinsi").toString()
        val positive:String = intent.extras?.get("positive").toString()
        val recover:String = intent.extras?.get("recover").toString()
        val died:String = intent.extras?.get("died").toString()

        binding.btnClose.setOnClickListener(this)
        binding.tvKodeProvinsi.text = kode
        binding.tvProvince.text = provinsi
        binding.tvPositif.text = positive
        binding.tvRecover.text = recover
        binding.tvDied.text = died

    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.btn_close -> {
                onBackPressed()
            }
        }
    }
}