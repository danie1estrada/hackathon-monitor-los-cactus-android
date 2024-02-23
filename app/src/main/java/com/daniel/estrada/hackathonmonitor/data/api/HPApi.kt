package com.daniel.estrada.hackathonmonitor.data.api

import com.daniel.estrada.hackathonmonitor.data.models.Character
import com.daniel.estrada.hackathonmonitor.data.models.Spell
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
interface HPApi {
    @GET("api/characters")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("api/character/{id}")
    suspend fun getCharacter(@Path("id") id: String): Response<Character>

    @GET("api/students")
    suspend fun getStudents(): Response<List<Character>>

    @GET("api/staff")
    suspend fun getStaff(): Response<List<Character>>

    @GET("api/house/{house}")
    suspend fun getCharactersByHouse(@Path("house") house: String): Response<List<Character>>

    @GET("api/spells")
    suspend fun getSpells(): Response<List<Spell>>
}