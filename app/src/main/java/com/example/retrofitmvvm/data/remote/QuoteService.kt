package com.example.retrofitmvvm.data.remote

import com.example.retrofitmvvm.data.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Tirth Patel.
 */
interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int): Response<QuoteList>
}

//BASE_URL + "/quotes?page=1"  Whatever we pass in page parameter
//We define methods here to call API
//Whichever end point we define here we can access it from repository