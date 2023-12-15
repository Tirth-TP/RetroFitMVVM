package com.example.retrofitmvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvm.data.remote.QuoteService
import com.example.retrofitmvvm.data.remote.RetrofitHelper
import com.example.retrofitmvvm.data.repository.QuoteRepository
import com.example.retrofitmvvm.viewmodel.MainViewModel
import com.example.retrofitmvvm.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repo = QuoteRepository(service)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this) {
            Log.d("TAG", "API DATA --> ${it.results}")
        }
    }
}