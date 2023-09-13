package br.com.atarashi.goldenRaspberryAwardsKotlin.facade

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film

interface FilmFacade {

    fun intervaloPremio(films: List<Film>): IntervaloPremioResponse
}