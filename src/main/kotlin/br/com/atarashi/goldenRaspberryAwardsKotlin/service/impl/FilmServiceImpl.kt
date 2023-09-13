package br.com.atarashi.goldenRaspberryAwardsKotlin.service.impl

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.request.FilmRequest
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.FilmResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.facade.FilmFacade
import br.com.atarashi.goldenRaspberryAwardsKotlin.mapper.FilmMapper
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.FilmRepository
import br.com.atarashi.goldenRaspberryAwardsKotlin.service.FilmService
import org.springframework.stereotype.Service

@Service
class FilmServiceImpl(
    private val filmRepository: FilmRepository,
    private val filmFacade: FilmFacade,
    private val filmMapper: FilmMapper
): FilmService {

    override fun insert(filmRequest: FilmRequest) {
        filmRepository.insert(filmMapper.filmRequestToFilm(filmRequest))
    }

    override fun delete(id: Int) {
        filmRepository.delete(id)
    }

    override fun findAll(): List<FilmResponse> {
        return filmMapper.filmListToFilmResponseList(filmRepository.findAll())
    }

    override fun findId(id: Int): FilmResponse {
        return filmMapper.filmToFilmResponse(filmRepository.findId(id))
    }

    override fun premiosConsecutivos(): IntervaloPremioResponse {
        return filmFacade.intervaloPremio(filmRepository.findByWinner())
    }
}