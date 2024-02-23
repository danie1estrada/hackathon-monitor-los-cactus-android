package com.daniel.estrada.hackathonmonitor.data.models

import com.daniel.estrada.hackathonmonitor.domain.models.Wand as DomainWand
data class Wand(
    val core: String,
    val length: Double?,
    val wood: String
)

fun Wand.toDomain(): DomainWand = DomainWand(
    core, length, wood
)