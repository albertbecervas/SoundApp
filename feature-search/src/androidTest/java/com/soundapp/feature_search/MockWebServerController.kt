package com.soundapp.feature_search


import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

object MockWebServerController {

    private lateinit var mockWebServer: MockWebServer

    fun <T> buildMockedService(service: Class<T>): T {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
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

    fun setUpOkResponseWithBody(body: String, delay: Long) {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBodyDelay(delay, TimeUnit.MILLISECONDS)
            .setBody(body)
        mockWebServer.enqueue(response)
    }

    fun shutDown() {
        mockWebServer.shutdown()
    }
}