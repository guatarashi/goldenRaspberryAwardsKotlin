package br.com.atarashi.goldenRaspberryAwardsKotlin.controller

import br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("films")
class FilmDeleteController(
    private val filmService: FilmService
) {

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Int) =
        filmService.delete(id)
}