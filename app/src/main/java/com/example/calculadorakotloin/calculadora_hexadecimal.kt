package com.example.calculadorakotloin

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadora_hexadecimal.*
import java.lang.ArithmeticException
import java.lang.Long.parseLong

class calculadora_hexadecimal : AppCompatActivity() {

    var operacionH=""
    var num1H=""
    var num2H=""
    var resultadoH: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_hexadecimal)

        val orientation=resources.configuration.orientation
        if(orientation==Configuration.ORIENTATION_LANDSCAPE){
            calHex();
        }else{
            val intentDecimalH = Intent(this,MainActivity::class.java)
            startActivity(intentDecimalH)
        }
    }

    fun operHex(hexa1: Long, hexa2: Long){
        when(operacionH){
            "+" -> resultadoH=(hexa1+hexa2)
            "-" -> resultadoH=(hexa1-hexa2)
            "*" -> resultadoH=(hexa1*hexa2)
            "/" -> resultadoH=(hexa1/hexa2)
        }
        var stringHex=java.lang.Long.toHexString(resultadoH)
        textResultadoH.text= stringHex.uppercase()
        num1H=textResultadoH.text.toString()
    }

    fun hexTodec(hexa: String): Long{
        return parseLong(hexa,16)
    }

    fun calHex(){
        btn0H.setOnClickListener(){
            num1H+="0"
            textResultadoH.setText(num1H)
        }
        btn1H.setOnClickListener(){
            num1H+="1"
            textResultadoH.setText(num1H)
        }
        btn2H.setOnClickListener(){
            num1H+="2"
            textResultadoH.setText(num1H)
        }
        btn3H.setOnClickListener(){
            num1H+="3"
            textResultadoH.setText(num1H)
        }
        btn4H.setOnClickListener(){
            num1H+="4"
            textResultadoH.setText(num1H)
        }
        btn5H.setOnClickListener(){
            num1H+="5"
            textResultadoH.setText(num1H)
        }
        btn6H.setOnClickListener(){
            num1H+="6"
            textResultadoH.setText(num1H)
        }
        btn7H.setOnClickListener(){
            num1H+="7"
            textResultadoH.setText(num1H)
        }
        btn8H.setOnClickListener(){
            num1H+="8"
            textResultadoH.setText(num1H)
        }
        btn9H.setOnClickListener(){
            num1H+="9"
            textResultadoH.setText(num1H)
        }
        btnA.setOnClickListener(){
            num1H+="A"
            textResultadoH.setText(num1H)
        }
        btnB.setOnClickListener(){
            num1H+="B"
            textResultadoH.setText(num1H)
        }
        btnC.setOnClickListener(){
            num1H+="C"
            textResultadoH.setText(num1H)
        }
        btnD.setOnClickListener(){
            num1H+="D"
            textResultadoH.setText(num1H)
        }
        btnE.setOnClickListener(){
            num1H+="E"
            textResultadoH.setText(num1H)
        }
        btnF.setOnClickListener(){
            num1H+="F"
            textResultadoH.setText(num1H)
        }
        btnSumaH.setOnClickListener(){
            operacionH="+"
            num2H=num1H
            num1H=""
            textResultadoH.text=num2H+"+"
        }
        btnRestaH.setOnClickListener(){
            operacionH="-"
            num2H=num1H
            num1H=""
            textResultadoH.text=num2H+"-"
        }
        btnMultiplicacionH.setOnClickListener(){
            operacionH="*"
            num2H=num1H
            num1H=""
            textResultadoH.text=num2H+"*"
        }
        btnDivisionH.setOnClickListener(){
            operacionH="/"
            num2H=num1H
            num1H=""
            textResultadoH.text=num2H+"/"
        }
        btnReseteoH.setOnClickListener(){
            num1H=""
            num2H=""
            textResultadoH.setText(num1H)
        }
        btnIgualH.setOnClickListener(){
            if(num2H=="") num2H="0"
            try{
                operHex(hexTodec(num2H),hexTodec(num1H))
            }catch (e: ArithmeticException){
                textResultadoH.text="No se puede dividir por 0"
            }
        }

        btnDecimalH.setOnClickListener(){
            val intentDecimalH = Intent(this,MainActivity::class.java)
            startActivity(intentDecimalH)
        }

        btnBinarioH.setOnClickListener(){
            val intentBinarioH = Intent(this,calculadora_binario::class.java)
            startActivity(intentBinarioH)
        }
    }
}