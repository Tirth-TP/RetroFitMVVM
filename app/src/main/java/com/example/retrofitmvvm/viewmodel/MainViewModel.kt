package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitmvvm.data.model.QuoteList
import com.example.retrofitmvvm.data.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Tirth Patel.
 */
class MainViewModel(val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuote(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = quoteRepository.quotes
}

//Generally for multiple api call we create function here