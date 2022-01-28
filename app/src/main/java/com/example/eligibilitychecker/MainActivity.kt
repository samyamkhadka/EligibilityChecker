package com.example.eligibilitychecker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var etFirstName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etAge: EditText
    private lateinit var etCountry: EditText
    private lateinit var btnApply: Button
    private lateinit var tvEligibility: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnApply = findViewById(R.id.btnApply)
        tvEligibility = findViewById(R.id.tvEligiblity)

        btnApply.setOnClickListener{
            etFirstName = findViewById(R.id.etFirstName)
            etLastName = findViewById(R.id.etLastName)
            etAge = findViewById(R.id.etAge)
            etCountry = findViewById(R.id.etCountry)
            eligibility()
        }
    }

    private fun eligibility() {
        val countries: List<String> = listOf("Canada", "Germany", "China", "India", "Russia")
        val age: String = etAge.text.toString()
        var ageNum: Int
        val name = "${etFirstName.text} ${etLastName.text}"
        val country : String = etCountry.text.toString()
        if (country.isNotEmpty() and age.isNotEmpty()) {
            ageNum = age.toInt()
        }
        else {
            tvEligibility.setTextColor(Color.parseColor("#FF0000"))
            tvEligibility.text = "Please Input the valid information!"
            return
        }

        finalCheck(name, ageNum, country, countries)
    }

    private fun finalCheck(name: String, ageNum:Int, country: String, countries: List<String>){
        if(ageNum>17) {
            if(country in countries){
                tvEligibility.setTextColor(Color.parseColor("#00FF00"))
                tvEligibility.text = "$name you are eligible apply!"
            }else{
                tvEligibility.setTextColor(Color.parseColor("#FF0000"))
                tvEligibility.text = "Residence of the country of $country are not eligible to apply!"
                return
            }
        } else{
            tvEligibility.setTextColor(Color.parseColor("#FF0000"))
            tvEligibility.text = "Your age of $ageNum, is not eligible to apply!"
            return
        }
    }

}

