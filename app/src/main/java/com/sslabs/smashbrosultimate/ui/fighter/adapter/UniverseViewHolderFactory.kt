package com.sslabs.smashbrosultimate.ui.fighter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sslabs.smashbrosultimate.databinding.ItemUniverseChipBinding
import javax.inject.Inject

class UniverseViewHolderFactory @Inject constructor(
    private val listener: UniverseViewHolder.OnUniverseClickListener
) {
    fun create(parent: ViewGroup) = UniverseViewHolder(
        ItemUniverseChipBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        listener
    )
}