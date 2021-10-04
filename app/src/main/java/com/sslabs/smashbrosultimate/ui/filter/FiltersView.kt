package com.sslabs.smashbrosultimate.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.base.navigation.IScreensNavigator
import com.sslabs.smashbrosultimate.databinding.FragmentFiltersBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FiltersView : Fragment() {

    private lateinit var binding: FragmentFiltersBinding
    @Inject lateinit var screensNavigator: IScreensNavigator
    private val viewModel: FiltersViewModel by hiltNavGraphViewModels(R.id.navigation)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFiltersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initToolbar()
        binding.filterApplyButton.setOnClickListener {
            screensNavigator.fromFilters(viewModel.getCriteria())
        }
    }

    private fun initToolbar() {
        binding.selectFighterToolbar.toolbar.let {
            it.title = getString(R.string.txt_toolbar_filters_title)
            it.menu.findItem(R.id.filter_options).isVisible = false
            it.setNavigationOnClickListener {
                screensNavigator.fromFilters(null)
            }
        }
    }
}