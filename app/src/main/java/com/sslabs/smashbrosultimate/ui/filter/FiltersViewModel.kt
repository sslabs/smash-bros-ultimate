package com.sslabs.smashbrosultimate.ui.filter

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.CompositeCriteria
import com.sslabs.smashbrosultimate.util.Criteria
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

@HiltViewModel
class FiltersViewModel @Inject constructor() : ViewModel() {

    private val criteriaMapping: MutableMap<KClass<out Fragment>, Criteria<Fighter>> =
        mutableMapOf()

    fun addCriteria(owner: KClass<out Fragment>, criteria: Criteria<Fighter>) {
        criteriaMapping[owner] = criteria
    }

    fun getCriteria() = Filters().apply { criteriaMapping.map { this.append(it.value) } }
}

class Filters : CompositeCriteria<Fighter>()