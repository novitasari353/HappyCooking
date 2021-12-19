package com.novitasari.happycooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.nilatilmoena.happycooking.models.ingredients.bahan
import com.novitasari.happycooking.api.informationApi4
import com.novitasari.happycooking.api.ingredientsApi4
import com.novitasari.happycooking.models.info.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rec2 : AppCompatActivity() {
    lateinit var CookAPI: ingredientsApi4
    lateinit var InfoAPI: informationApi4
    private var BASE_URL = "https://api.spoonacular.com/"
    lateinit var tvIngResponse: TextView
    lateinit var tvInfResponse: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec2)
        val actionbar = supportActionBar
        actionbar!!.title = "Details"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        tvIngResponse = findViewById(R.id.bahan4)
        tvInfResponse = findViewById(R.id.step4)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        CookAPI = retrofit.create(ingredientsApi4::class.java)
        InfoAPI = retrofit.create(informationApi4::class.java)

        getBahan()
        getStep()

    }

    fun getBahan() {
        val call: Call<bahan> = CookAPI.getResponse()

        call.enqueue(object : Callback<bahan> {
            override fun onResponse(call: Call<bahan>, response: Response<bahan>) {
                if (response.body() != null) {
                    var ingContent = ""

                    ingContent += "1. " + response.body()!!.ingredients[0].name + " (" + response.body()!!.ingredients[0].amount.metric.value + " dash)" + ", "
                    ingContent += "2. " + response.body()!!.ingredients[1].name + " (" + response.body()!!.ingredients[1].amount.metric.value + " g)" + ", "
                    ingContent += "3. " + response.body()!!.ingredients[2].name + " (" + response.body()!!.ingredients[2].amount.metric.value + " g)" + ", "
                    ingContent += "4. " + response.body()!!.ingredients[3].name + " (" + response.body()!!.ingredients[3].amount.metric.value + " )" + ", "
                    ingContent += "5. " + response.body()!!.ingredients[4].name + " (" + response.body()!!.ingredients[4].amount.metric.value + " tsps)" + ", "
                    ingContent += "6. " + response.body()!!.ingredients[5].name + " (" + response.body()!!.ingredients[5].amount.metric.value + " tsps)" + ", "
                    ingContent += "7. " + response.body()!!.ingredients[6].name + " (" + response.body()!!.ingredients[6].amount.metric.value + " tsps)" + ", "
                    ingContent += "8. " + response.body()!!.ingredients[7].name + " (" + response.body()!!.ingredients[7].amount.metric.value + " tsp)" + ", "



                    tvIngResponse.setText(ingContent)

                }
            }

            override fun onFailure(call: Call<bahan>, t: Throwable) {
                tvIngResponse.setText("Error occured: " + t)
            }
        })
    }
    fun getStep() {
        val call: Call<info> = InfoAPI.getResponse()

        call.enqueue(object : Callback<info> {
            override fun onResponse(call: Call<info>, response: Response<info>) {
                if (response.body() != null) {
                    var stepContent = ""

                    stepContent += response.body()!!.instructions
                    tvInfResponse.loadData(stepContent, "text/html", null)

                }
            }

            override fun onFailure(call: Call<info>, t: Throwable) {
                tvInfResponse.loadData("Error occured: " + t, "text/html", null)
            }

        })
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
