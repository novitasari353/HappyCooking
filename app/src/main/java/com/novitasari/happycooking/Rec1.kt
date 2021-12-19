package com.novitasari.happycooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.TextView
import com.nilatilmoena.happycooking.models.ingredients.bahan
import com.novitasari.happycooking.api.informationApi3
import com.novitasari.happycooking.api.ingredientsApi3
import com.novitasari.happycooking.models.info.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rec1 : AppCompatActivity() {
    lateinit var CookAPI: ingredientsApi3
    lateinit var InfoAPI: informationApi3
    private var BASE_URL = "https://api.spoonacular.com/"
    lateinit var tvIngResponse: TextView
    lateinit var tvInfResponse: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rec1)
        val actionbar = supportActionBar
        actionbar!!.title = "Details"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        tvIngResponse = findViewById(R.id.bahan3)
        tvInfResponse = findViewById(R.id.step3)

        // Retrofit
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        CookAPI = retrofit.create(ingredientsApi3::class.java)
        InfoAPI = retrofit.create(informationApi3::class.java)

        getBahan()
        getStep()

    }

    fun getBahan() {
        val call: Call<bahan> = CookAPI.getResponse()

        call.enqueue(object : Callback<bahan> {
            override fun onResponse(call: Call<bahan>, response: Response<bahan>) {
                if (response.body() != null) {
                    var ingContent = ""

                    ingContent += "1. " + response.body()!!.ingredients[0].name + " (" + response.body()!!.ingredients[0].amount.metric.value + " tbsps)" + ", "
                    ingContent += "2. " + response.body()!!.ingredients[1].name + " (" + response.body()!!.ingredients[1].amount.metric.value + " medium)" + ", "
                    ingContent += "3. " + response.body()!!.ingredients[2].name + " (" + response.body()!!.ingredients[2].amount.metric.value + " large)" + ", "
                    ingContent += "4. " + response.body()!!.ingredients[3].name + " (" + response.body()!!.ingredients[3].amount.metric.value + " stalk)" + ", "
                    ingContent += "5. " + response.body()!!.ingredients[4].name + " (" + response.body()!!.ingredients[4].amount.metric.value + " g)" + ", "
                    ingContent += "6. " + response.body()!!.ingredients[5].name + " (" + response.body()!!.ingredients[5].amount.metric.value + " cloves)" + ", "
                    ingContent += "7. " + response.body()!!.ingredients[6].name + " (" + response.body()!!.ingredients[6].amount.metric.value + " tsp)" + ", "
                    ingContent += "8. " + response.body()!!.ingredients[7].name + " (" + response.body()!!.ingredients[7].amount.metric.value + " tsp)" + ", "
                    ingContent += "9. " + response.body()!!.ingredients[8].name + " (" + response.body()!!.ingredients[8].amount.metric.value + " tsps)" + ", "
                    ingContent += "10. " + response.body()!!.ingredients[9].name + " (" + response.body()!!.ingredients[9].amount.metric.value + " tsps)" + ", "
                    ingContent += "11. " + response.body()!!.ingredients[5].name + " (" + response.body()!!.ingredients[10].amount.metric.value + " g)" + ", "
                    ingContent += "12. " + response.body()!!.ingredients[6].name + " (" + response.body()!!.ingredients[11].amount.metric.value + " g)" + ", "
                    ingContent += "13. " + response.body()!!.ingredients[7].name + " (" + response.body()!!.ingredients[12].amount.metric.value + " ml)" + ", "
                    ingContent += "14. " + response.body()!!.ingredients[8].name + " (" + response.body()!!.ingredients[13].amount.metric.value + " ml)" + ", "
                    ingContent += "15. " + response.body()!!.ingredients[9].name + " (" + response.body()!!.ingredients[14].amount.metric.value + " serving)" + ", "



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
