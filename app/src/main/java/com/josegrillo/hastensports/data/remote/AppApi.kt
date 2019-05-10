package com.josegrillo.hastensports.data.remote

import android.content.Context
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
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

        fun create(context: Context): AppApi {


            val httpClient = setApiClient(context)

            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                //.baseUrl(BuildConfig.BASE_URL)
                .build()

            return retrofit.create(AppApi::class.java)
        }


        private fun setApiClient(context: Context): OkHttpClient? {

            var client: OkHttpClient?

            try {

                client = OkHttpClient.Builder()
                    .addInterceptor(
                        LoggingInterceptor.Builder()
                            .loggable(true)
                            .setLevel(Level.BASIC)
                            .log(Platform.INFO)
                            //.request(ConstantesApp.SOLICITUD_TAG)
                            //.response(ConstantesApp.RESPUESTA_TAG)
                            .build()
                    )
                    .build()


            } catch (exception: Exception) {

                client = null

            }




            return client

        }

    }

}