package com.sslabs.smashbrosultimate.ui.welcome

import androidx.lifecycle.*
import com.sslabs.smashbrosultimate.R
import com.sslabs.smashbrosultimate.data.local.pref.IPreferences
import com.sslabs.smashbrosultimate.data.model.WalkthroughStepConfiguration
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalkthroughViewModel @Inject constructor(
    private val prefs: IPreferences
) : ViewModel() {

    private val _step = MutableLiveData<WalkthroughStep>()
    val step: LiveData<WalkthroughStep> get() = _step

    val stepConfiguration: LiveData<WalkthroughStepConfiguration> =
        Transformations.map(_step) { step -> getStepConfiguration(step) }

    fun setStep(step: WalkthroughStep) {
        _step.value = step
    }

    fun setWalkthroughComplete() {
        viewModelScope.launch(Dispatchers.IO) {
            prefs.setWalkthroughDisplayed()
        }
    }

    private fun getStepConfiguration(step: WalkthroughStep): WalkthroughStepConfiguration {
        return when (step) {
            WalkthroughStep.FIRST -> WalkthroughStepConfiguration(
                R.string.walkthrough_fighter_1,
                R.drawable.wt_fighter1
            )
            WalkthroughStep.SECOND -> WalkthroughStepConfiguration(
                R.string.walkthrough_fighter_2,
                R.drawable.wt_fighter2
            )
            WalkthroughStep.THIRD -> WalkthroughStepConfiguration(
                R.string.walkthrough_fighter_3,
                R.drawable.wt_fighter3
            )
        }
    }
}
