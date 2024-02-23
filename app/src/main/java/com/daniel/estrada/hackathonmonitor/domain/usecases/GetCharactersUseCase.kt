package com.daniel.estrada.hackathonmonitor.domain.usecases

import com.daniel.estrada.hackathonmonitor.domain.repository.HPRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: HPRepository
) {
    suspend operator fun invoke() = repository.getCharacters()
}