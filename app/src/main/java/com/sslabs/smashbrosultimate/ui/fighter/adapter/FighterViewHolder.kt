package com.sslabs.smashbrosultimate.ui.fighter.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.databinding.ItemFighterBinding

class FighterViewHolder(private val itemBinding: ItemFighterBinding) :
    RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    init {
        itemBinding.root.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        Toast.makeText(view.context, itemBinding.itemFighterName.text, Toast.LENGTH_SHORT).show()
    }

    fun bind(fighter: Fighter) {
        itemBinding.apply {
            Picasso.get()
                .load(fighter.imageUrl)
                .into(this.itemFighterImage)
            this.itemFighterName.text = fighter.name
            this.itemFighterUniverse.text = fighter.universe
        }
    }
}