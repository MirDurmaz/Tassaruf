package com.example.tassaruf.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoTasaruf {

   @Insert
   suspend fun HacrcamaEkle(ode:Harcama)

   @Query("SELECT * FROM HARCAMA")
    fun ButunHarcamaGelsin():LiveData<List<Harcama>>

}