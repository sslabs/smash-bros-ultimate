package com.sslabs.smashbrosultimate.util

import java.io.Serializable

interface Criteria<T> : Serializable {
    fun apply(set: List<T>): List<T>
}

abstract class CompositeCriteria<T> : Criteria<T> {
    private val criteriaList: MutableList<Criteria<T>> = mutableListOf()

    override fun apply(set: List<T>): List<T> = apply(set, criteriaList.toList())

    fun append(criteria: Criteria<T>) {
        criteriaList.add(criteria)
    }

    private fun apply(set: List<T>, remainingCriteria: List<Criteria<T>>): List<T> =
        when(remainingCriteria.size) {
            0 -> set
            1 -> criteriaList.first().apply(set)
            else -> {
                val mutableCriteriaList = remainingCriteria.toMutableList()
                val criteria = mutableCriteriaList.removeFirst()
                apply(criteria.apply(set), mutableCriteriaList)
            }
        }
}