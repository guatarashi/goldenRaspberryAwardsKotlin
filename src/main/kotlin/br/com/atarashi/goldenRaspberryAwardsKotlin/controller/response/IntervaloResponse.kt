package br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response

data class IntervaloResponse(
    val producer: String,
    val interval: String,
    val previousWin: String,
    val followingWin: String
)
