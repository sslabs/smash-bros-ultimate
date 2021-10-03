package com.sslabs.smashbrosultimate.ui.fighter.adapter

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView

class UniverseRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    private val universeAdapter: UniverseOptionsAdapter get() = adapter as UniverseOptionsAdapter

    fun selectUniverseAt(position: Int) {
        post { universeAdapter.setSelectedAt(position) }
    }
}