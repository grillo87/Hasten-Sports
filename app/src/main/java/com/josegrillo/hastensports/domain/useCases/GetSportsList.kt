package com.josegrillo.hastensports.domain.useCases

import com.josegrillo.hastensports.data.remote.AppApi
import com.josegrillo.hastensports.domain.models.api.SportsModel
import io.reactivex.Observable
import javax.inject.Inject

class GetSportsList @Inject constructor(private val appApi: AppApi) {

    fun getSportsList(): Observable<List<SportsModel>> = appApi.getSportsList()

}