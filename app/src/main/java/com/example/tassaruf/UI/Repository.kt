package com.example.tassaruf.UI

import com.example.tassaruf.Database.DaoTasaruf
import com.example.tassaruf.Database.Harcama

class Repository (val dao:DaoTasaruf) {

suspend fun HarcamaEkle(paraGit:Harcama)=dao.HacrcamaEkle(paraGit)
fun GetirHarcama()=dao.ButunHarcamaGelsin()

}