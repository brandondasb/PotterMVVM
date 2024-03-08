package com.lambostudio.pottermvvm.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

class OnlineData {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getSpellsList(): List<NetworkSpell> {
        val data = mutableListOf<NetworkSpell>()
        try {
            val httpResponse: HttpResponse = client.get("https://hp-api.onrender.com/api/spells") {
                contentType(ContentType.Application.Json)
            }
            if (httpResponse.status.value in 200..299) {
                httpResponse.body<List<NetworkSpell>>()
                data.addAll(httpResponse.body<List<NetworkSpell>>())
            } else {
                println("its nottt working")

            }
        } catch (e: Error) {
            Log.d("###ALLDATA", "Error getting documents.${e.message}", e)
        }
        return data
    }
}
