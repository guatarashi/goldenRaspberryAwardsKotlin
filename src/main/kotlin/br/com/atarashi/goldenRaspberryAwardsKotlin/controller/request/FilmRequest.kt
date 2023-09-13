package br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request

data class FilmRequest(
    val year: String,
    val title: String,
    val studios: String,
    val producers: String,
    val winner: String
)
