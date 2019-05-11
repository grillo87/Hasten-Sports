package com.josegrillo.hastensports.domain.models.mappers

import com.josegrillo.hastensports.domain.models.api.PlayersModel
import com.josegrillo.hastensports.views.models.Player


fun PlayersModel.playerModelToPlayerView(): Player = Player(this.image, this.surname, this.name)

