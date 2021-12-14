package com.example.calculadorakotloin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var tipoOperacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //funcion de botones numero
        btnHexadecimal.setOnClickListener{
            val intentHexadecimal = Intent(this,calculadora_hexadecimal::class.java)
            startActivity(intentHexadecimal)
        }

        btnBinario.setOnClickListener {
            val intentBinario = Intent(this,calculadora_binario::class.java)
            startActivity(intentBinario)
        }
                btn0.setOnClickListener{numeroBtn("0")}
                btn1.setOnClickListener{numeroBtn("1")}

                btn2.setOnClickListener{numeroBtn("2")}
                btn3.setOnClickListener{numeroBtn("3")}
                btn4.setOnClickListener{numeroBtn("4")}
                btn5.setOnClickListener{numeroBtn("5")}
                btn6.setOnClickListener{numeroBtn("6")}
                btn7.setOnClickListener{numeroBtn("7")}
                btn8.setOnClickListener{numeroBtn("8")}
                btn9.setOnClickListener{numeroBtn("9")}
                btnComa.setOnClickListener{numeroBtn(".")}


        //funcion de botones operacions
        btnSuma.setOnClickListener{operacionBtn(SUMA)}
        btnResta.setOnClickListener{operacionBtn(RESTA)}
        btnMultiplicacion.setOnClickListener{operacionBtn(MULTIPLICACION)}
        btnDivision.setOnClickListener{operacionBtn(DIVISION)}

        //funcion del boton de reseteo
        btnReseteo.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            tipoOperacion = SIN_OPERACION
            textResultado.text = ""

        }

        //funcion del boton de igual
        btnIgual.setOnClickListener{
            var resultado = when (tipoOperacion){
                SUMA -> num1+num2
                RESTA -> num1-num2
                MULTIPLICACION -> num1*num2
                DIVISION ->
                    if (num2 == 0.0){
                        textResultado.text = "ERROR, IMPOSIBLE DIVIDIR POR 0"
                    }else num1/num2
                else -> 0
            }

            textResultado.text = resultado.toString()
            num1 = textResultado.text.toString().toDouble()

        }



    }



    //constantes
    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVISION=4
        const val SIN_OPERACION=0
    }
    //metodo para poner los numeros en pantalla y añadirlos al numero1 o el numero2


    private fun numeroBtn(numero: String){
        textResultado.text = "${textResultado.text}$numero"
            if (tipoOperacion == SIN_OPERACION){
                num1 = textResultado.text.toString().toDouble()
            }else{
                num2 = textResultado.text.toString().toDouble()
            }

            if (tipoOperacion == SIN_OPERACION){
                num1 = textResultado.text.toString().toLong(radix = 16).toDouble()
            }else{
                num2 = textResultado.text.toString().toLong(radix = 16).toDouble()
            }



            if (tipoOperacion == SIN_OPERACION){
                num1 = textResultado.text.toString().toLong(radix = 16).toDouble()
            }else{
                num2 = textResultado.text.toString().toLong(radix = 16).toDouble()
            }
    }

    //metodo para tomar los valores de pantalla y añadirlo al numero
    private fun operacionBtn(tipoOperacion: Int){
        this.tipoOperacion = tipoOperacion
        textResultado.text = ""
    }


}