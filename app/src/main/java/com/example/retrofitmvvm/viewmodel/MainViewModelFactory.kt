package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.data.repository.QuoteRepository

/**
 * Created by Tirth Patel.
 */
class MainViewModelFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}