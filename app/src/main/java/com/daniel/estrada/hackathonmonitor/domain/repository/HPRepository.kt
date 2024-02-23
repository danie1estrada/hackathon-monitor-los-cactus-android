package com.daniel.estrada.hackathonmonitor.domain.repository

import com.daniel.estrada.hackathonmonitor.domain.models.Character
import com.daniel.estrada.hackathonmonitor.domain.models.Response
import com.daniel.estrada.hackathonmonitor.domain.models.Spell

interface HPRepository {
    suspend fun getCharacters(): Response<List<Character>>

    suspend fun getCharacter(id: String): Response<Character>

    suspend fun getStudents(): Response<List<Character>>

    suspend fun getStaff(): Response<List<Character>>

    suspend fun getCharactersByHouse(house: String): Response<List<Character>>

    suspend fun getSpells(): Response<List<Spell>>
}