package com.sslabs.smashbrosultimate.ui.fighter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.databinding.ItemFighterBinding
import javax.inject.Inject

class FighterListAdapter @Inject constructor() : RecyclerView.Adapter<FighterViewHolder>() {

    private var fighters: MutableList<Fighter> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FighterViewHolder {
        val itemBinding =
            ItemFighterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FighterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: FighterViewHolder, position: Int) {
        holder.bind(fighters[position])
    }

    override fun getItemCount(): Int = fighters.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(fightersList: List<Fighter>) {
        fighters.clear()
        fightersList.map {
            fighters.add(it)
        }
        notifyDataSetChanged()
    }
}