package com.sslabs.smashbrosultimate.ui.fighter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.databinding.ItemUniverseChipBinding

class UniverseViewHolder(
    private val itemBinding: ItemUniverseChipBinding,
    private val listener: OnUniverseClickListener
) : RecyclerView.ViewHolder(itemBinding.root) {

    interface OnUniverseClickListener {
        fun onUniverseSelected(universeBinding: ItemUniverseChipBinding)
    }

    init {
        itemBinding.universeChip.setOnClickListener {
            itemBinding.universeChip.let {
                it.isClickable = !it.isChecked
                listener.onUniverseSelected(itemBinding)
            }
        }
    }

    fun bind(universe: Universe, isSelected: Boolean) {
        itemBinding.universeChip.let {
            it.isChecked = isSelected
            it.isClickable = !isSelected
            it.text = universe.name
        }
    }
}