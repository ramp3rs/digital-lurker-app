package io.digitallurker.utils

import kotlinx.coroutines.runBlocking
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

object TokenManager {
    fun getNewToken() {
        val host = "http://192.168.125.141:8000"

        val refresh: String = PrefsManager.getInstance().getString("refresh", "error")!!

        val client = OkHttpClient()
        val formData = FormBody.Builder()
            .add("refresh", refresh)
            .build()
        val req = Request.Builder()
            .url("$host/auth/token/refresh/")
            .post(formData)
            .build()

        runBlocking{
            client.newCall(req).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.code == 201 || response.code == 200) {
                        val res = response.body?.string()
                        PrefsManager.getInstance().edit().putString("access", JSONObject(res).getString("access")).apply()
                        println(PrefsManager.getInstance().getString("access", "error"))
                    } else {
                        //DODAĆ ZABIERANIE DO LOGINU!!!
                        println("Error!")
                    }
                }
            })
        }
    }
}