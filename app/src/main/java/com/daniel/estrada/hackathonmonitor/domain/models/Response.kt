package com.daniel.estrada.hackathonmonitor.domain.models

data class Response<T>(
    val status: String,
    val code: Int,
    val data: T?
)