package udacoding.test.assignmentudacoding.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getBatik(): NetworkService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://batikita.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(NetworkService::class.java)
        }

        fun getMuseum(): NetworkService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(NetworkService::class.java)
        }

        fun getProvince(): NetworkService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dev.farizdotid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(NetworkService::class.java)
        }

        fun getCovid(): NetworkService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://indonesia-covid-19.mathdro.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(NetworkService::class.java)
        }

    }

}