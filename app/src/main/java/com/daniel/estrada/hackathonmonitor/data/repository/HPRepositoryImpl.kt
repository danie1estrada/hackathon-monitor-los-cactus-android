package com.daniel.estrada.hackathonmonitor.data.repository

import com.daniel.estrada.hackathonmonitor.data.api.HPApi
import com.daniel.estrada.hackathonmonitor.data.models.toDomain
import com.daniel.estrada.hackathonmonitor.domain.models.Character
import com.daniel.estrada.hackathonmonitor.domain.models.Response
import com.daniel.estrada.hackathonmonitor.domain.models.Spell
import com.daniel.estrada.hackathonmonitor.domain.repository.HPRepository
import javax.inject.Inject

class HPRepositoryImpl @Inject constructor(
    private val api: HPApi
) : HPRepository {
    override suspend fun getCharacters(): Response<List<Character>> {
        val result = api.getCharacters()
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.map { it.toDomain() }
        )
    }

    override suspend fun getCharacter(id: String): Response<Character> {
        val result = api.getCharacter(id)
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.toDomain()
        )
    }

    override suspend fun getStudents(): Response<List<Character>> {
        val result = api.getStudents()
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.map { it.toDomain() }
        )
    }

    override suspend fun getStaff(): Response<List<Character>> {
        val result = api.getStaff()
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.map { it.toDomain() }
        )
    }

    override suspend fun getCharactersByHouse(house: String): Response<List<Character>> {
        val result = api.getCharactersByHouse(house)
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.map { it.toDomain() }
        )
    }

    override suspend fun getSpells(): Response<List<Spell>> {
        val result = api.getSpells()
        return Response(
            status = if (result.isSuccessful) "Active" else "Inactive",
            code = result.code(),
            data = result.body()?.map { it.toDomain() }
        )
    }
}