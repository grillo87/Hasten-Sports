package com.josegrillo.hastensports.views.ui.viewHolders

import android.view.View
import com.josegrillo.hastensports.views.models.Sport
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.sport_item_viewholder.view.*


class SportItemViewHolder(val view: View) : GroupViewHolder(view) {


    fun bind(sport: Sport) {

        view.sportNameTextview.text = sport.name

    }


}