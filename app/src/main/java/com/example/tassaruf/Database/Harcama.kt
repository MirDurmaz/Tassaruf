package com.example.tassaruf.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Harcama (
   @ColumnInfo(name = "HARACAMA_TURU")
    val harcamaTuru:String,
   @ColumnInfo(name = "HARCAMA_MIKTARI")
    val harcamaMiktari:Int,
   @ColumnInfo(name = "HARCAMA_TARIHI")
   val harcamaTarihi:String

        ) {
@PrimaryKey(autoGenerate = true)
var harcamaId:Int?=null
}