package com.josegrillo.hastensports.domain.models.api

import com.google.gson.annotations.SerializedName

data class PlayersModel (@SerializedName("image") val image: String,
                         @SerializedName("surname") val surname: String,
                         @SerializedName("name") val name: String)