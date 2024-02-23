package com.daniel.estrada.hackathonmonitor.data.models

import com.google.gson.annotations.SerializedName
import com.daniel.estrada.hackathonmonitor.domain.models.Character as DomainCharacter
data class Character(
    val actor: String,
    val alive: Boolean,
    @SerializedName("alternate_actors")
    val alternateActors: List<String>,
    @SerializedName("alternate_names")
    val alternateNames: List<String>,
    val ancestry: String,
    val dateOfBirth: String?,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: Wand,
    val wizard: Boolean,
    val yearOfBirth: Int?
)

fun Character.toDomain(): DomainCharacter = DomainCharacter(
    actor, alive, alternateActors, alternateNames, ancestry, dateOfBirth, eyeColour, gender, hairColour, hogwartsStaff, hogwartsStudent, house, id, image, name, patronus, species, wand, wizard, yearOfBirth
)
