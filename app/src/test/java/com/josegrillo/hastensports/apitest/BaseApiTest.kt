package com.josegrillo.hastensports.apitest

import com.josegrillo.hastensports.data.remote.AppApi
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import java.io.IOException

open class BaseApiTest {

    lateinit var appApi: AppApi
    lateinit var mockWebServer: MockWebServer

    @Before
    fun init() {
        mockWebServer = MockWebServer()
        appApi = AppApi.create(mockWebServer.url("/").toString())

    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        mockWebServer.shutdown()
    }
}