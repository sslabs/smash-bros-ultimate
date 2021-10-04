package com.sslabs.smashbrosultimate.ui.fighter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.navArgs
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.base.navigation.IScreensNavigator
import com.sslabs.smashbrosultimate.databinding.FragmentSelectFighterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SelectFighterView : Fragment() {

    @Inject lateinit var screensNavigator: IScreensNavigator
    private lateinit var binding: FragmentSelectFighterBinding
    private val viewModel: SelectFighterViewModel by hiltNavGraphViewModels(R.id.navigation)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectFighterBinding.inflate(inflater, container, false)
        val safeArgs: SelectFighterViewArgs by navArgs()
        viewModel.setFilters(safeArgs.filters)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initViews()
    }

    private fun initViews() {
        initToolbar()
    }

    private fun initToolbar() {
        binding.selectFighterToolbar.toolbar.let {
            it.title = getString(R.string.txt_toolbar_fighters_title)
            it.navigationIcon = null
            it.setOnMenuItemClickListener { menu ->
                when(menu.itemId) {
                    R.id.filter_options -> {
                        screensNavigator.fromSelectFighterToFilters()
                        true
                    }
                    else -> false
                }
            }
            if (viewModel.filters.value != null)  {
                it.menu.findItem(R.id.filter_options).icon =
                    ContextCompat.getDrawable(
                        it.context,
                        R.drawable.ic_filter_selected
                    )
            }
        }
    }
}