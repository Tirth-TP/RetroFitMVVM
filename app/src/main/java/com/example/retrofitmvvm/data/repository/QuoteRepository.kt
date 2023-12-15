package com.example.retrofitmvvm.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvm.data.model.QuoteList
import com.example.retrofitmvvm.data.remote.QuoteService

/**
 * Created by Tirth Patel.
 */
class QuoteRepository(private val quotesService: QuoteService) {
    //throw QuoteService we access API
     private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>     //Publicly accessible live data
        get() = quotesLiveData

    //We will call this method from viewModel.
    // From this method will get QuoteList type object. so we define quotesLiveData type QuoteList.
    suspend fun getQuote(page: Int) {
        val result = quotesService.getQuotes(page)
        if (result?.body() !== null) {
            quotesLiveData.postValue(result.body())
        }
    }
}


/*

quotesLiveData.postValue(result.body()) :
postValue is a method provided by the LiveData class.
It is used to set the value of the LiveData from a background thread.

quotesLiveData.value = result.body() :
Directly assigning a value using the value property is a shortcut when you are already on the main thread.
This approach is suitable when you are in a context where you are sure that you are on the main thread,
such as within a ViewModel or in response to a UI event.
*/