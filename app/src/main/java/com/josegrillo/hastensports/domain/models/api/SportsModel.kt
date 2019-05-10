package com.josegrillo.hastensports.domain.models.api

import com.google.gson.annotations.SerializedName

data class SportsModel (@SerializedName("players") val players: ArrayList<PlayersModel>,
                        @SerializedName("type") val type: String,
                        @SerializedName("title") val title: String)