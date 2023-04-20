package com.henhein.regradetres


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.henhein.regradetres.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)

        supportActionBar?.hide()



    }

    override fun onClick(v: View) {


        if(v.id==R.id.button_calculate) {
            if (isValid()) {
                calculate()
            } else {
                Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_SHORT).show()
            }
        }


    }
    private fun isValid(): Boolean {


        return binding.editTextNumero1C1.text.toString()!=""&&
                binding.editTextNumero2C1.text.toString()!=""&&
                binding.editTextNumero1C2.text.toString()!="" &&
                binding.editTextNumero1C1.text.toString().toFloat()!=0f

    }
    private fun calculate(){
        var n1c1 =binding.editTextNumero1C1.text.toString().toFloat()
        var n2c1=  binding.editTextNumero2C1.text.toString().toFloat()
        var n1c2= binding.editTextNumero1C2.text.toString().toFloat()

        var n2c2=n1c2*n2c1/n1c1


        binding.textViewResult.text = "Resultado: ${"%.2f".format(n2c2)}"

    }
    private fun definirRota(){
        println("Definição de rota iniciando...")
    }
    private fun comprarCombustivel(){
        println("Comprando na promoção...")
    }
}