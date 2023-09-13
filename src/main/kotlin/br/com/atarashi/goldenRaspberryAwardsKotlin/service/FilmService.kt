package br.com.atarashi.goldenRaspberryAwardsKotlin.service

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse

interface FilmService {

    fun insert(filmRequest: FilmRequest)

    fun delete(id: Int)

    fun findAll(): List<FilmResponse>

    fun findId(id: Int): FilmResponse

    fun premiosConsecutivos(): IntervaloPremioResponse
}