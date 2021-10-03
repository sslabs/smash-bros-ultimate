package com.sslabs.smashbrosultimate.ui.fighter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.repository.fighter.IFighterRepository
import com.sslabs.smashbrosultimate.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FighterListViewModel @Inject constructor(
    private val fighterRepository: IFighterRepository
) : ViewModel() {

    private val _fighterData: MutableLiveData<DataState<List<Fighter>>> = MutableLiveData()
    val fighterData: LiveData<DataState<List<Fighter>>> get() = _fighterData

    fun setStateEvent(fighterListStateEvent: FighterListStateEvent) {
        viewModelScope.launch {
            when(fighterListStateEvent) {
                is FighterListStateEvent.GetAllFightersEvent -> {
                    fighterRepository.getAllFighters()
                        .onEach { _fighterData.value = it }
                        .launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class FighterListStateEvent {
    object GetAllFightersEvent: FighterListStateEvent()
}