package com.example.tassaruf.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Harcama::class],
version = 1
    )
abstract class DatabaseHarcama:RoomDatabase () {

    abstract fun getDao():DaoTasaruf

    companion object{

        @Volatile
       private var instance:DatabaseHarcama?=null
       private var LOCK=Any ()

        operator fun invoke(context: Context)= instance ?:synchronized(LOCK){

           instance ?:createDatabase(context).also{instance=it}
        }

        private fun createDatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,DatabaseHarcama::class.java,"Taser").build()

    }
}