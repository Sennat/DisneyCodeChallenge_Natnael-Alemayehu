package com.project.disneycodechallenge_natnaelalemayehu.repositories

import com.project.disneycodechallenge_natnaelalemayehu.model.Guest
import com.project.disneycodechallenge_natnaelalemayehu.utils.GuestNameList.GuestNameListProvider.populateGuestsNameList
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor() : DataRepository {
    private var guestList: MutableList<Guest> = mutableListOf()

    // Create and initialize all guests list
    override suspend fun getAllGuestsList(): MutableList<Guest> {
        populateGuestsNameList().forEach {
            guestList.run {
                add(
                    Guest(name = it)
                )
            }
        }
        return guestList
    }

}