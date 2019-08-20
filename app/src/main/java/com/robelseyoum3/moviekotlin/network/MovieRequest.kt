
package com.robelseyoum3.moviekotlin.network


import com.robelseyoum3.moviekotlin.models.MoviePopular
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRequest {

    @GET("movie/popular")
    fun getMoviesPopular(@Query("api_key") apiKey: String): Call<MoviePopular>

}