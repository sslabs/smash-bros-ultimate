package com.sslabs.smashbrosultimate.ui.fighter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.databinding.FragmentFighterListBinding
import com.sslabs.smashbrosultimate.ui.fighter.adapter.FighterListAdapter
import com.sslabs.smashbrosultimate.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class FighterListView : Fragment() {

    private lateinit var binding: FragmentFighterListBinding
    private val viewModel: SelectFighterViewModel by hiltNavGraphViewModels(R.id.navigation)

    @Inject
    lateinit var adapter: FighterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFighterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViews()
        observerData()
    }

    private fun initViews() {
        binding.fighterListContainer.adapter = adapter
    }

    private fun observerData() {
        viewModel.fighterData.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success<List<Fighter>> -> {
                    binding.fighterListHeader.text =
                        getString(R.string.txt_figther_list_count, it.data.size)
                    adapter.setData(it.data)
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