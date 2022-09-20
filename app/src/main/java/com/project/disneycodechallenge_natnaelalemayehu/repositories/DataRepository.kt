package com.project.disneycodechallenge_natnaelalemayehu.repositories

import com.project.disneycodechallenge_natnaelalemayehu.model.Guest

interface DataRepository {
    suspend fun getAllGuestsList() : List<Guest>
}