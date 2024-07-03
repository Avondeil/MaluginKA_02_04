package com.example.malugin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

lateinit var slider : Slider
lateinit var edit: EditText
lateinit var textCredit: TextView
lateinit var buttonRas: AppCompatButton
class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        slider = findViewById(R.id.slider)
        edit = findViewById(R.id.termEdit)
        textCredit = findViewById(R.id.monthlyPayment)
        buttonRas = findViewById(R.id.buttonLogin)

        buttonRas.setOnClickListener{
            // работает только на вариант а), больше сделать не успел
            if (edit.text.toString().toDouble()/12 < 1)
            {
               textCredit.text =  (slider.value/edit.text.toString().toInt()+slider.value*0.059).toString()
            }
        }



    }
}