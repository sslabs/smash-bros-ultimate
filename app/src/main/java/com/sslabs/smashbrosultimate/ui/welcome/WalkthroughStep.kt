package com.sslabs.smashbrosultimate.ui.welcome

enum class WalkthroughStep {
    FIRST, SECOND, THIRD;

    fun next(): WalkthroughStep = when(this) {
        FIRST -> SECOND
        SECOND -> THIRD
        else -> throw IllegalStateException("$this has no next")
    }

    fun hasNext(): Boolean = when(this) {
        FIRST, SECOND -> true
        THIRD -> false
    }
}