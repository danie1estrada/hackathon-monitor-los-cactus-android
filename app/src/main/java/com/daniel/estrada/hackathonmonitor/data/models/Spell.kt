package com.daniel.estrada.hackathonmonitor.data.models

import com.daniel.estrada.hackathonmonitor.domain.models.Spell as DomainSpell
data class Spell(
    val description: String,
    val id: String,
    val name: String
)

fun Spell.toDomain(): DomainSpell = DomainSpell(
    description, id, name
)