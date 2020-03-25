package com.soundapp.feature_search


import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import java.net.HttpURLConnection

object MockWebServerController {

    private val mockWebServer: MockWebServer = MockWebServer()

    fun <T> buildMockedService(service: Class<T>): T {
        mockWebServer.start()
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(OkHttpClient())
            .build()
            .create(service)
    }

    fun setUpOkResponseWithBody(body: String) {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(body)
        mockWebServer.enqueue(response)
    }

    fun shutDown() {
        mockWebServer.shutdown()
    }
}