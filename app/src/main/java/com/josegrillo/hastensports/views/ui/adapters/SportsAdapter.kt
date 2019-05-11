package com.josegrillo.hastensports.views.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.views.models.Player
import com.josegrillo.hastensports.views.models.Sport
import com.josegrillo.hastensports.views.ui.viewHolders.PlayerItemViewHolder
import com.josegrillo.hastensports.views.ui.viewHolders.SportItemViewHolder
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class SportsAdapter(val sportsArrayList: ArrayList<Sport>) :
    ExpandableRecyclerViewAdapter<SportItemViewHolder, PlayerItemViewHolder>(sportsArrayList) {

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): SportItemViewHolder {

        return SportItemViewHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.sport_item_viewholder, parent, false)
        )

    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): PlayerItemViewHolder {

        return PlayerItemViewHolder(
            LayoutInflater.from(parent?.context)
                .inflate(R.layout.player_item_viewholder, parent, false)
        )

    }

    override fun onBindChildViewHolder(
        holder: PlayerItemViewHolder?,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {

        group?.let {

            val player: Player = it.items[childIndex] as Player
            holder?.bind(player)

        }

    }

    override fun onBindGroupViewHolder(holder: SportItemViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?) {

        group?.let {

            val sport: Sport = it as Sport
            holder?.bind(sport)

        }

    }

}