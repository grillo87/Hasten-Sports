package com.josegrillo.hastensports.data.remote

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import com.josegrillo.hastensports.BuildConfig
import com.josegrillo.hastensports.domain.models.api.SportsModel
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AppApi {

    @GET("66851")
    fun getSportsList(): Observable<List<SportsModel>>

    companion object Factory {

        fun create(baseUrl: String): AppApi {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(
                LoggingInterceptor.Builder()
                    .loggable(BuildConfig.API_DEBUG)
                    .setLevel(Level.BODY)
                    .setLevel(Level.HEADERS)
                    .log(Platform.INFO)
                    .request(BuildConfig.REQUEST_API_TAG)
                    .response(BuildConfig.RESPONSE_API_TAG)
                    .build()
            )

            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .baseUrl(baseUrl)
                .build()

            return retrofit.create(AppApi::class.java)
        }

    }

}