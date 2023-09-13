package br.com.atarashi.goldenRaspberryAwardsKotlin.mapper

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface FilmMapper {

    fun filmToFilmResponse(film: Film): FilmResponse

    fun filmListToFilmResponseList(film: List<Film>): List<FilmResponse>

    fun filmRequestToFilm(filmRequest: FilmRequest): Film
}