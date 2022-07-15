package com.example.tassaruf.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class factoryView(private val repository: Repository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return View(repository) as T
    }
}