package br.com.atarashi.goldenRaspberryAwardsKotlin.controller

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("films")
class FilmFetchController(
    private val filmService: FilmService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun fetch(): List<FilmResponse> {
        return filmService.findAll()
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun fetchId(@PathVariable id: Int): FilmResponse {
        return filmService.findId(id)
    }
}