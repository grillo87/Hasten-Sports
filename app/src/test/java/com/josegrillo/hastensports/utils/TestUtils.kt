package com.josegrillo.cabifydemo.utils

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.robolectric.RuntimeEnvironment
import java.io.InputStream


fun MockWebServer.queueResponse(block: MockResponse.() -> Unit) {
    this.enqueue(MockResponse().apply(block))
}


fun String.getResponseFromJson(): String {

    try {
        val inputStream: InputStream =
            RuntimeEnvironment.application.applicationContext.assets.open("api-response/$this.json")
        val inputString = inputStream.bufferedReader().use {
            it.readText()
        }
        return inputString
    } catch (e: Exception) {
        return ""
    }
}



