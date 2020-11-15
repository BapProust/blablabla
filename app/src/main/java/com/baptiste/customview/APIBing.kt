package com.baptiste.customview

import android.text.Editable
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class APIBing {
    val client = OkHttpClient()
    var urlResponse: String? = null
    val gson = Gson()

    fun response(searchQuery: Editable?): String? {

        var subscriptionKey = "98206790c24c4f59a361ee7ba02ebc12"
        var host = "https://api.cognitive.microsoft.com"
        var path = "/bing/v7.0/images/search?"
        var searchTerm = searchQuery.toString()

        var url = host + path + "q='$searchTerm'&count=1&imageType=Transparent"

        val request = Request.Builder()
            .header("Ocp-Apim-Subscription-Key", subscriptionKey)
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val APIresponse = gson.fromJson(response.body?.string(), BingImage::class.java)
                urlResponse = APIresponse.value?.get(0)?.contentUrl
            }
        })
        return urlResponse
    }
}