package com.robelseyoum3.moviekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.moviekotlin.models.MoviePopular
import com.robelseyoum3.moviekotlin.network.MovieRequest
import com.robelseyoum3.moviekotlin.network.RetrofitInstances
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieRequest = RetrofitInstances().retrofitInstances.create(MovieRequest::class.java)

        val call = movieRequest.getMoviesPopular(Constants.API_KEY)

        call.enqueue(object : Callback<MoviePopular> {
            override fun onFailure(call: Call<MoviePopular>, t: Throwable) {
                Log.d("MainActivity", t.message)

            }

            override fun onResponse(call: Call<MoviePopular>, response: Response<MoviePopular>) {
                val res = response.body()
                Log.d("MainActivity", res!!.results[0].title)
            }
        })

    }
}
