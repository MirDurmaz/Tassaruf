package com.example.tassaruf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tassaruf.Database.DatabaseHarcama
import com.example.tassaruf.Database.Harcama
import com.example.tassaruf.UI.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val databaseTasaruf=DatabaseHarcama(this)
        val tasarufDao=databaseTasaruf.getDao()
        val tasarufReppsitory=Repository(tasarufDao)
        val tasarufFactory=factoryView(tasarufReppsitory)
        val tasarufView=ViewModelProvider(this,tasarufFactory).get(View::class.java)

        val adaltor=AdaptorHarcama(listOf())
        recycTasaruf.layoutManager=LinearLayoutManager(this)
        recycTasaruf.adapter=adaltor

        tasarufView.GetAllPurchaes().observe(this,{
          adaltor.gitPara=it
            adaltor.notifyDataSetChanged()
        })

        btnEkle.setOnClickListener {
          DialogHarcama(this,object :GetValueHarcama{
              override fun getValue(harcama: Harcama) {
                  tasarufView.InsertHarcama(harcama)
              }
          }).show()
        }
    }
}