package com.sslabs.smashbrosultimate.ui.fighter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.databinding.FragmentUniverseOptionsBinding
import com.sslabs.smashbrosultimate.databinding.ItemUniverseChipBinding
import com.sslabs.smashbrosultimate.ui.fighter.adapter.UniverseOptionsAdapter
import com.sslabs.smashbrosultimate.ui.fighter.adapter.UniverseViewHolder
import com.sslabs.smashbrosultimate.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class UniverseOptionsView : Fragment(), UniverseViewHolder.OnUniverseClickListener {

    private lateinit var binding: FragmentUniverseOptionsBinding
    private val viewModel: SelectFighterViewModel by hiltNavGraphViewModels(R.id.navigation)

    @Inject
    lateinit var adapter: UniverseOptionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUniverseOptionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onUniverseSelected(universeBinding: ItemUniverseChipBinding) {
        binding.universeChipContainer.post {
            binding.universeChipContainer.let {
                Timber.d("[onUniverseSelected] hasPendingAdapterUpdates=${it.hasPendingAdapterUpdates()}")
                val universePosition = it.getChildAdapterPosition(universeBinding.root)
                Timber.d("[onUniverseSelected] universePosition=$universePosition")
                it.selectUniverseAt(universePosition)

                val universe = if (adapter.universes[universePosition].id != null) {
                    adapter.universes[universePosition]
                } else {
                    null
                }
                val getFighterEvent =
                    SelectFighterStateEvent.GetFightersEvent(universe)
                viewModel.setStateEvent(getFighterEvent)
            }
        }
    }

    private fun init() {
        initViews()
        observerData()

        viewModel.setStateEvent(SelectFighterStateEvent.GetAllUniversesEvent)
    }

    private fun initViews() {
        binding.universeChipContainer.adapter = adapter
    }

    private fun observerData() {
        viewModel.universeData.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success<List<Universe>> -> {
                    adapter.setData(it.data)
                    if (adapter.itemCount > 0) {
                        binding.universeChipContainer.selectUniverseAt(0)
                        viewModel.setStateEvent(SelectFighterStateEvent.GetFightersEvent())
                    }
                }
                is DataState.Error -> {
                    Timber.e(it.exception)
                }
                is DataState.Loading -> {
                }
            }
        })
    }
}