package com.project.disneycodechallenge_natnaelalemayehu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.disneycodechallenge_natnaelalemayehu.model.Guest
import com.project.disneycodechallenge_natnaelalemayehu.repositories.DataRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepositoryImpl: DataRepositoryImpl) :
    ViewModel() {

    private var allGuestsList: MutableList<Guest> = mutableListOf()
    private var reservedGuests: MutableList<Guest> = mutableListOf()
    private var nonReservedGuests: MutableList<Guest> = mutableListOf()

    private val _reservedGuestsLiveData = MutableLiveData<List<Guest>>(emptyList())
    val reservedGuestsLiveData: LiveData<List<Guest>> get() = _reservedGuestsLiveData

    private val _nonReservedGuestsLiveData = MutableLiveData<List<Guest>>(emptyList())
    val nonReservedGuestsLiveData: LiveData<List<Guest>> get() = _nonReservedGuestsLiveData

    init {
        this.getAllGuestList()
        this.getReservedGuestList()
        this.getNonReservedGuestList()
    }

    //Get all guests list
    private fun getAllGuestList() {
        viewModelScope.launch {
            allGuestsList = dataRepositoryImpl.getAllGuestsList()
            allGuestsList.shuffle()
        }
    }

    // Create reserved guests list
    private fun getReservedGuestList() {
        viewModelScope.launch {
            for (i in allGuestsList) {
                reservedGuests.add(i)
            }
            _reservedGuestsLiveData.postValue(reservedGuests)
        }
    }

    // Create none reserved guests list
    private fun getNonReservedGuestList() {
        viewModelScope.launch {
            for (i in reservedGuests.take(3)) {
                nonReservedGuests.add(i)
                reservedGuests.remove(i)
            }
            allGuestsList.clear()
            _nonReservedGuestsLiveData.postValue(nonReservedGuests)
        }
    }
}