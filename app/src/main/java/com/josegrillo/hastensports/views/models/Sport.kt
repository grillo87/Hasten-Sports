package com.josegrillo.hastensports.views.models

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

data class Sport (val name : String,
                  val players: ArrayList<Player>) : ExpandableGroup<Player>(name, players)