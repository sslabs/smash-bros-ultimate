package com.sslabs.smashbrosultimate.ui.fighter.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sslabs.smashbrosultimate.data.model.Universe

class UniverseOptionsAdapter(
    private val universeViewHolderFactory: UniverseViewHolderFactory
) : RecyclerView.Adapter<UniverseViewHolder>() {

    var universes: MutableList<Universe> = mutableListOf()
    private var selectedPosition = INVALID_POSITION

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniverseViewHolder {
        return universeViewHolderFactory.create(parent)
    }

    override fun onBindViewHolder(holder: UniverseViewHolder, position: Int) {
        holder.bind(universes[position], selectedPosition == position)
    }

    override fun getItemCount(): Int = universes.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(universeList: List<Universe>) {
        universes.clear()
        universes.add(createFirstModel())
        universeList.map {
            universes.add(it)
        }
        notifyDataSetChanged()
    }

    fun setSelectedAt(position: Int) {
        val lastPosition = selectedPosition
        selectedPosition = if (position == INVALID_POSITION) 0 else position

        if (lastPosition == INVALID_POSITION) {
            notifyItemChanged(0)
        } else {
            notifyItemChanged(lastPosition)
        }
    }

    private fun createFirstModel() = Universe(
        id = null,
        name = ALL_NAME,
        description = null
    )

    companion object {
        const val INVALID_POSITION = -1;
        const val ALL_NAME = "ALL"
    }
}
