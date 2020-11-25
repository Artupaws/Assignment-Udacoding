package udacoding.test.assignmentudacoding.view.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import udacoding.test.assignmentudacoding.R
import udacoding.test.assignmentudacoding.databinding.ActivityDetailMuseumBinding

class DetailMuseumActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailMuseumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMuseumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nama:String = intent.extras?.get("nama").toString()
        val kode:String = intent.extras?.get("kode").toString()
        val alamat:String = intent.extras?.get("alamat").toString()
        val kecamatan:String = intent.extras?.get("kecamatan").toString()
        val kota:String = intent.extras?.get("kota").toString()
        val provinsi:String = intent.extras?.get("provinis").toString()
        val dana:String = intent.extras?.get("dana").toString()
        val pengelola:String = intent.extras?.get("pengelola").toString()
        val tipe:String = intent.extras?.get("tipe").toString()
        val berdiri:String = intent.extras?.get("berdiri").toString()

        binding.btnClose.setOnClickListener(this)
        binding.tvMuseumName.text = nama
        binding.tvCodeDevelop.text = kode
        binding.tvAddressMuseum.text = alamat
        binding.tvKecamatan.text = kecamatan
        binding.tvKota.text = kota
        binding.tvProvinsi.text = provinsi
        binding.tvDana.text = dana
        binding.tvPengelola.text = pengelola
        binding.tvTipe.text = tipe
        binding.tvTahunBerdiri.text = berdiri
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            R.id.btn_close -> {
                onBackPressed()
            }
        }
    }
}