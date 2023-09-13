package br.com.atarashi.goldenRaspberryAwardsKotlin.controller

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest
import br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("films")
class FilmInsertController(
    private val filmService: FilmService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun insert(@RequestBody filmRequest: FilmRequest) {
        filmService.insert(filmRequest)
    }
}