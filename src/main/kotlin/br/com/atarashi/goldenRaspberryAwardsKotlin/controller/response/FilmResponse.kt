package br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response

data class FilmResponse(
    val id: Int,
    val year: String,
    val title: String,
    val studios: String,
    val producers: String,
    val winner: String?
)
