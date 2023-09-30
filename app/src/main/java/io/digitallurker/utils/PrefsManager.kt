package io.digitallurker.utils

import android.content.Context
import android.content.SharedPreferences

object PrefsManager {
    private lateinit var prefs: SharedPreferences

    fun initialize(context: Context) {
        prefs = context.getSharedPreferences("digital-lurker-prefs", Context.MODE_PRIVATE)
    }
    fun getInstance(): SharedPreferences = prefs



}