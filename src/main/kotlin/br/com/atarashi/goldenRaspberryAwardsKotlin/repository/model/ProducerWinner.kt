package br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model

data class ProducerWinner(
    val year: Int,
    val producer: String,
    var delete: Boolean? = false,
    var interval: Int? = 0
)
