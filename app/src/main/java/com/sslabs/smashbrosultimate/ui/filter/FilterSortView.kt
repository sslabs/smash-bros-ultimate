package com.sslabs.smashbrosultimate.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.databinding.FragmentFilterSortBinding
import com.sslabs.smashbrosultimate.util.Criteria
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterSortView : Fragment() {

    private lateinit var binding: FragmentFilterSortBinding
    private val viewModel: FiltersViewModel by hiltNavGraphViewModels(R.id.navigation)
    private lateinit var availableCriteria: Map<RadioButton, SortCriteria>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterSortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        availableCriteria = mapOf(
            createRadioButton(getString(R.string.sort_criteria_ascending)) to SortCriteria.Ascending(),
            createRadioButton(getString(R.string.sort_criteria_descending)) to SortCriteria.Descending(),
            createRadioButton(getString(R.string.sort_criteria_rate)) to SortCriteria.Rate(),
            createRadioButton(getString(R.string.sort_criteria_downloads)) to SortCriteria.Downloads(),
        )

        binding.filterRadioGroup.let {
            availableCriteria.keys.map { key -> it.addView(key) }
        }

        binding.filterRadioGroup.setOnCheckedChangeListener { radioGroup, checkedId ->
            val selected: RadioButton = radioGroup.findViewById(checkedId)
            availableCriteria[selected]?.let{
                viewModel.addCriteria(this@FilterSortView::class, it)
            }
        }
    }

    private fun createRadioButton(title: String): RadioButton =
        RadioButton(context).apply {
            this.text = title
        }
}

abstract class SortCriteria : Criteria<Fighter> {
    class Ascending : SortCriteria() {
        override fun apply(set: List<Fighter>): List<Fighter> = set.sortedBy { it.name }
    }
    class Descending : SortCriteria() {
        override fun apply(set: List<Fighter>): List<Fighter> = set.sortedByDescending { it.name }
    }
    class Rate : SortCriteria() {
        override fun apply(set: List<Fighter>): List<Fighter> = set.sortedBy { it.rate }
    }
    class Downloads : SortCriteria() {
        override fun apply(set: List<Fighter>): List<Fighter> = set.sortedBy { it.downloads }
    }
}
