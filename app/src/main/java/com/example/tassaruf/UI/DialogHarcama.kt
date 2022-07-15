package com.example.tassaruf.UI

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.tassaruf.Database.Harcama
import com.example.tassaruf.R
import kotlinx.android.synthetic.main.harcama_add.*
import java.util.*

class DialogHarcama(context: Context, var getValueHarcama: GetValueHarcama):AppCompatDialog(context),DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    var year=0
    var month=0
    var day=0
    var hour=0
    var minute=0

    var yearSaved=0
    var monthSaved=0
    var daySaved=0
    var hourSaved=0
    var minuteSaved=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.harcama_add)
        var harmTuri:String=""

        pickDate()
       btnKaydet.setOnClickListener {
           val harcamaValue = edtMiktar.text.toString()

           if (harcamaValue.isEmpty() || harmTuri !== "") {
               Toast.makeText(context, "Lütfen Harcama Değeri Girin", Toast.LENGTH_SHORT).show()
               return@setOnClickListener
           }
           if (giyimHarcama.isChecked){
               harmTuri="Giyim"
           }
           else if (digerHarcama.isChecked)
           {harmTuri="Diger"

           }
           else if (OzelHarcama.isChecked)
           {
               harmTuri="Ozel"
           }
           else{
               harmTuri="Mutfak"
           }
           val setHarcama = Harcama(harmTuri, harcamaValue.toInt(), "$yearSaved-$monthSaved-$daySaved  $hourSaved:$minuteSaved ")
           getValueHarcama.getValue(setHarcama)
           dismiss()

       }

       btnSil.setOnClickListener {
           cancel()
       }



    }


    private fun getTimeCalendar(){
        val call=Calendar.getInstance()
        day=call.get(Calendar.DAY_OF_MONTH)
        month=call.get(Calendar.MONTH)
        year=call.get(Calendar.YEAR)
        hour=call.get(Calendar.HOUR)
        minute=call.get(Calendar.MINUTE)
    }

    private fun pickDate(){
        btnTime.setOnClickListener {
            getTimeCalendar()
            DatePickerDialog(context,this,year,month,day).show()
        }

    }


    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        yearSaved=p1
        monthSaved=p2
        daySaved=p3

        getTimeCalendar()
        TimePickerDialog(context,this,hour,minute,true).show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        hourSaved=p1
        minuteSaved=p2
    }



}