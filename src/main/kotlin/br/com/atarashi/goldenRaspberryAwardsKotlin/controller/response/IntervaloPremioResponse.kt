package br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response

data class IntervaloPremioResponse(
    var min: List<IntervaloResponse>,
    var max: List<IntervaloResponse>
)