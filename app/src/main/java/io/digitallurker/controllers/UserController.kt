package io.digitallurker.controllers

import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object UserController {
    fun login(
        email: String,
        password: String,
    ): Boolean {
        val client = OkHttpClient()
        val formData = FormBody.Builder()
            .add("email", email)
            .add("password", password)
            .build()
        val req = Request.Builder()
            .url("http://192.168.125.141:8000/auth/token/")
            .post(formData)
            .build()

        var successfulLogin = false
        client.newCall(req).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code == 201) {
                    successfulLogin = true
                }
                println(response.body?.string())
            }
        })
        return successfulLogin
    }

    fun signup(
        username: String,
        email: String,
        dateOfBirth: String,
        password: String,
    ): Boolean {
        val client = OkHttpClient()
        val formData = FormBody.Builder()
            .add("username", username)
            .add("email", email)
            .add("date_of_birth", password)
            .add("password", password)
            .build()
        val req = Request.Builder()
            .url("")
            .post(formData)
            .build()
        var successfulSignup = false
        client.newCall(req).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code == 201) {
                    successfulSignup = true
                }
                println(response.body?.string())
            }
        })
        return successfulSignup

    }
}