package io.digitallurker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.digitallurker.models.Attraction
import io.digitallurker.ui.components.home.AccountHeadline
import io.digitallurker.ui.components.home.AttractionElement
import io.digitallurker.ui.components.home.SearchBar
import io.digitallurker.ui.theme.ColorPalette
import io.digitallurker.ui.theme.Measurements
import io.digitallurker.utils.PrefsManager
import io.digitallurker.utils.TokenManager.getNewToken
import kotlinx.coroutines.runBlocking
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

@Composable
fun HomeScreen(navCtrl: NavController) {
    LaunchedEffect(Unit) {
        getPlaces("Point(51.399653660577 21.149885920182005)", "50000000000")
    }
    Surface(
        color = ColorPalette.background,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Measurements.screenPadding)
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AccountHeadline(navCtrl)
            SearchBar {}
            Spacer(Modifier.height(15.dp))
//            for (i in 0..10) {
//                AttractionElement(navCtrl)
//            }
        }
    }
}

fun getPlaces(
    point: String,
    range: String,
): List<Attraction> {
    val host = "http://192.168.125.141:8000"

    val client = OkHttpClient()

    val access: String = PrefsManager.getInstance().getString("access", "error")!!

    val urlBuilder = "$host/places/search/".toHttpUrlOrNull()!!.newBuilder()
    urlBuilder.addQueryParameter("range", range)

    val req = Request.Builder()
        .url(urlBuilder.build())
        .header("point", point)
        .header("Authorization", "Bearer $access")
        .build()

    var attractions = emptyList<Attraction>()

    runBlocking {
        client.newCall(req).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code == 201 || response.code == 200) {
                    val res = response.body?.string()
                    if (res != null) {
                        val jsonResponse = JSONObject(res).getString("results")
                        val gson = Gson()
                        val listType = object : TypeToken<List<Attraction>>() {}.type
                        val attractionList: List<Attraction> = gson.fromJson(jsonResponse, listType)
                        attractions = attractionList
                    }
                } else if (response.code == 401) {
                    println("Error")
                    getNewToken()
                    getPlaces(point, range)
                } else {
                    println("Error code: $response")
                }
            }
        })
    }
    return attractions
}