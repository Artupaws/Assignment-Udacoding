package udacoding.test.assignmentudacoding.network

import retrofit2.Call
import retrofit2.http.GET
import udacoding.test.assignmentudacoding.model.ResponseBatik
import udacoding.test.assignmentudacoding.model.ResponseCorona
import udacoding.test.assignmentudacoding.model.ResponseMuseum
import udacoding.test.assignmentudacoding.model.ResponseProvince

interface NetworkService {

    @GET("index.php/batik/all")
    fun getDataBatik():Call<ResponseBatik>

    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getDataMuseum():Call<ResponseMuseum>

    @GET("api/daerahindonesia/provinsi")
    fun getDataProvince():Call<ResponseProvince>

    @GET("api/provinsi")
    fun getDataCovid():Call<ResponseCorona>
}