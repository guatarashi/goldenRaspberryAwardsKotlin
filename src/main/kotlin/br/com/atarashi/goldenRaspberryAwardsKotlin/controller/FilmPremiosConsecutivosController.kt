package br.com.atarashi.goldenRaspberryAwardsKotlin.controller

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("films")
class FilmPremiosConsecutivosController(
    private val filmService: FilmService
) {

    @GetMapping("premios-consecutivos")
    @ResponseStatus(HttpStatus.OK)
    fun premiosConsecutivos(): IntervaloPremioResponse {
        return filmService.premiosConsecutivos()
    }

}