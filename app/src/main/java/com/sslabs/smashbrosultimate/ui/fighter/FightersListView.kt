package com.sslabs.smashbrosultimate.ui.fighter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.databinding.FragmentFightersListViewBinding
import com.sslabs.smashbrosultimate.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class FightersListView : Fragment() {

    private lateinit var binding: FragmentFightersListViewBinding
    private val viewModel: FighterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFightersListViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initViews()
        observeData()

        viewModel.setStateEvent(FighterListStateEvent.GetAllFightersEvent)
        viewModel.setStateEvent(FighterListStateEvent.GetAllUniversesEvent)
    }

    private fun initViews() {

    }

    private fun observeData() {
        viewModel.fighterData.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success<List<Fighter>> -> {
                    binding.fightersTestTextview.text =
                        it.data.joinToString { fighter -> fighter.name }
                    displayProgressBar(false)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(it.exception.message)
                    Timber.e(it.exception)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })

        viewModel.universeData.observe(viewLifecycleOwner, {
            when (it) {
                is DataState.Success<List<Universe>> -> {
                    binding.universesTestTextview.text =
                        it.data.joinToString { fighter -> fighter.name }
                    displayProgressBar(false)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(it.exception.message)
                    Timber.e(it.exception)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        binding.fightersTestTextview.text = message ?: "Unknown error"
        binding.universesTestTextview.text = ""
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding.fightersListLoading.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}