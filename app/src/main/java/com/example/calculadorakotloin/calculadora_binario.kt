package com.example.calculadorakotloin

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora_binario.*
import java.lang.ArithmeticException
import java.lang.Long.parseLong

class calculadora_binario : AppCompatActivity() {
    var operacionB=""
    var num1B=""
    var num2B=""
    var resultadoB: Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_binario)

        val orientation = resources.configuration.orientation
        if (orientation==Configuration.ORIENTATION_LANDSCAPE){
            calBinario();
        }else{
            val intentDecimalB = Intent(this,MainActivity::class.java)
            startActivity(intentDecimalB)
        }
    }

    fun operBin(bina1: Long,bina2: Long){
        when(operacionB){
            "+" -> resultadoB=(bina1+bina2)
            "-" -> resultadoB=(bina1-bina2)
            "*" -> resultadoB=(bina1*bina2)
            "/" -> resultadoB=(bina1/bina2)
        }
        var stringBin=java.lang.Long.toBinaryString(resultadoB)
        textResultadoB.text = stringBin.uppercase()
        num1B=textResultadoB.text.toString()
    }

    fun binTodec(bina: String):Long{
        return parseLong(bina,2)
    }


    fun calBinario(){
        btn0B.setOnClickListener(){
            num1B+="0"
            textResultadoB.setText(num1B)
        }
        btn1B.setOnClickListener(){
            num1B+="1"
            textResultadoB.setText(num1B)
        }
        btnSumaB.setOnClickListener(){
            operacionB="+"
            num2B=num1B
            num1B=""
            textResultadoB.text=num2B+"+"
        }
        btnSumaB.setOnClickListener(){
            operacionB="-"
            num2B=num1B
            num1B=""
            textResultadoB.text=num2B+"-"
        }
        btnSumaB.setOnClickListener(){
            operacionB="*"
            num2B=num1B
            num1B=""
            textResultadoB.text=num2B+"*"
        }
        btnSumaB.setOnClickListener(){
            operacionB="/"
            num2B=num1B
            num1B=""
            textResultadoB.text=num2B+"/"
        }
        btnReseteoB.setOnClickListener(){
            num1B=""
            num2B=""
            textResultadoB.setText(num1B)
        }
        btnIgualB.setOnClickListener(){
            if(num2B=="") num2B="0"
            try{
                operBin(binTodec(num2B),binTodec(num1B))
            }catch (e: ArithmeticException){
                textResultadoB.text="No se puede dividir por 0"
            }
        }
        btnDecimalB.setOnClickListener(){
            val intentDecimalB = Intent(this,MainActivity::class.java)
            startActivity(intentDecimalB)
        }
        btnHexadecimalB.setOnClickListener(){
            val intentHexadecimalB = Intent(this,calculadora_hexadecimal::class.java)
            startActivity(intentHexadecimalB)
        }
    }
}