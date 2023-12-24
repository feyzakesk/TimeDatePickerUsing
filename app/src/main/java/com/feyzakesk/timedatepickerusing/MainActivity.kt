package com.feyzakesk.timedatepickerusing

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import com.feyzakesk.timedatepickerusing.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.editTextSaat.setOnClickListener {

            val calendar = Calendar.getInstance()

            val saat = calendar.get(Calendar.HOUR_OF_DAY)
            val dakika = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener { timepicker, s, dk ->

                binding.editTextSaat.setText("$s : $dk")

            },saat,dakika,true)

            timePicker.setTitle("Saat Seçiniz")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"AYARLA",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",timePicker)

            timePicker.show()

        }
        binding.editTextTarih.setOnClickListener {

            val calendar = Calendar.getInstance()

            val yil = calendar.get(Calendar.YEAR)
            val ay = calendar.get(Calendar.MONTH)
            val gun = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener { datePicker, y, a, g ->

                binding.editTextTarih.setText("$g/${a+1}/$y")

            },yil,ay,gun)

            datePicker.setTitle("Saat Seçiniz")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"AYARLA",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL",datePicker)

            datePicker.show()

        }
    }
}