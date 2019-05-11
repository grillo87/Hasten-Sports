package com.josegrillo.hastensports.domain.models.mappers

import com.josegrillo.hastensports.domain.models.api.SportsModel
import com.josegrillo.hastensports.views.models.Sport


fun SportsModel.sportModelToSportView(): Sport = Sport(this.title, ArrayList(this.players.map { it.playerModelToPlayerView() }))


