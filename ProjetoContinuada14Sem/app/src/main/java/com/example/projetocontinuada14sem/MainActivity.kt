package com.example.projetocontinuada14sem

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularContaminacao(v: View) {

        if (!et_nh.text.toString().equals("") && !et_c.text.toString().equals("")
            && !et_cidade.text.toString().equals("")
        ) {


            val habitantes = et_nh.text.toString().toDouble()
            val contaminados = et_c.text.toString().toDouble()
            val cidade = et_cidade.text.toString()




             if (contaminados > habitantes) {
                Toast.makeText(
                    this, "O Número de contaminados não pode ser maior " +
                            "que o número de habitantes", Toast.LENGTH_LONG
                ).show()
            }else if(habitantes < 1){
                Toast.makeText(
                    this, "O numero de habitantes não pode ser 0", Toast.LENGTH_LONG
                ).show()
            }

            else {
                val totalPorcentagem = (contaminados * 100) / habitantes


                if (totalPorcentagem <= 25.00) {
                    tv_resultado.text =
                        "A cidade de $cidade possui $totalPorcentagem % de infectados"
                    tv_resultado.setTextColor(Color.GREEN)
                    tv_resultado.visibility = View.VISIBLE
                } else if (totalPorcentagem > 25.00 && totalPorcentagem <= 75.00) {
                    tv_resultado.text =
                        "A cidade de $cidade possui $totalPorcentagem % de infectados"
                    tv_resultado.setTextColor(Color.parseColor("#E3EE00"))
                    tv_resultado.visibility = View.VISIBLE
                } else if (totalPorcentagem > 75.00) {
                    tv_resultado.text =
                        "A cidade de $cidade possui $totalPorcentagem % de infectados"
                    tv_resultado.setTextColor(Color.RED)
                    tv_resultado.visibility = View.VISIBLE
                }
            }
        }else {
                    Toast.makeText(this, "Por Favor, preencha todos os valores", Toast.LENGTH_LONG)
                        .show()
                }
            }


}

