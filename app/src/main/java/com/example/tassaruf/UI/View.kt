package com.example.tassaruf.UI

import androidx.lifecycle.ViewModel
import com.example.tassaruf.Database.Harcama
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class View(private val repository: Repository):ViewModel () {

  fun InsertHarcama(harcama: Harcama)= CoroutineScope(Dispatchers.Default).launch {
      repository.HarcamaEkle(harcama)
  }

    fun GetAllPurchaes()=repository.GetirHarcama()
}