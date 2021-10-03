package com.sslabs.smashbrosultimate.ui.fighter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.repository.fighter.IFighterRepository
import com.sslabs.smashbrosultimate.repository.universe.IUniverseRepository
import com.sslabs.smashbrosultimate.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectFighterViewModel @Inject constructor(
    private val fighterRepository: IFighterRepository,
    private val universeRepository: IUniverseRepository
) : ViewModel() {

    private val _fighterData: MutableLiveData<DataState<List<Fighter>>> = MutableLiveData()
    val fighterData: LiveData<DataState<List<Fighter>>> get() = _fighterData

    private val _universeData: MutableLiveData<DataState<List<Universe>>> = MutableLiveData()
    val universeData: LiveData<DataState<List<Universe>>> get() = _universeData

    fun setStateEvent(selectFighterStateEvent: SelectFighterStateEvent) {
        viewModelScope.launch {
            when (selectFighterStateEvent) {
                is SelectFighterStateEvent.GetFightersEvent -> {
                    fighterRepository.getFighters(selectFighterStateEvent.universe?.name)
                        .onEach { _fighterData.value = it }
                        .launchIn(viewModelScope)
                }
                is SelectFighterStateEvent.GetAllUniversesEvent -> {
                    universeRepository.getAllUniverses()
                        .onEach { _universeData.value = it }
                        .launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class SelectFighterStateEvent {
    class GetFightersEvent(val universe: Universe? = null) : SelectFighterStateEvent()
    object GetAllUniversesEvent : SelectFighterStateEvent()
}
