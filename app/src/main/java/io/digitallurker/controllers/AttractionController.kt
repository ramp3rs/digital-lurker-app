package io.digitallurker.controllers

import io.digitallurker.models.Attraction
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.IOException


object AttractionController {
    fun new(attraction: Attraction): Boolean {
        val host = "http://192.168.125.141:8000"

        val client = OkHttpClient()
        val formData = MultipartBody.Builder()
            .addFormDataPart("name", attraction.name)
            .addFormDataPart("location", attraction.location)
            .addFormDataPart("is_active", attraction.isActive.toString())
            .addFormDataPart("description", attraction.description)
            .addFormDataPart(
                "main_image",
                attraction.image.name,
                attraction.image.asRequestBody("multipart/form-data".toMediaTypeOrNull())
            )
            .build()

        val req = Request.Builder()
            .url("$host/users/")
            .post(formData)
            .build()
        try {
            val res = client.newCall(req).execute()
            if (res.isSuccessful) {
                return true
            }
        } catch (e: IOException) {
            return false
        }
        return false
    }
}