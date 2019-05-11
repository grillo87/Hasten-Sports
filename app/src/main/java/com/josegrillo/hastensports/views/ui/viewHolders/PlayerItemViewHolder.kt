package com.josegrillo.hastensports.views.ui.viewHolders

import android.view.View
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.josegrillo.hastensports.R
import com.josegrillo.hastensports.utils.GlideApp
import com.josegrillo.hastensports.views.models.Player
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import kotlinx.android.synthetic.main.player_item_viewholder.view.*

class PlayerItemViewHolder(val view: View) : ChildViewHolder(view) {
    fun bind(player: Player) {

        view.playerItemViewHolderName.text = player.name
        view.playerItemViewHolderSurName.text = player.surName

        GlideApp.with(view).load(player.image)
            .fitCenter()
            .error(R.drawable.fail_loading)
            .placeholder(R.drawable.loading_holder)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(view.playerItemViewHolderImage)


    }


}