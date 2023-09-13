package br.com.atarashi.goldenRaspberryAwardsKotlin.facade.impl

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.facade.FilmFacade
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.ProducerWinner
import java.util.stream.Stream
import org.springframework.stereotype.Service

@Service
class FilmFacadeImpl: FilmFacade {

    override fun intervaloPremio(films: List<Film>): IntervaloPremioResponse {
        val intervaloPremioResponses = IntervaloPremioResponse(mutableListOf(), mutableListOf())
        val producerWinners: MutableList<ProducerWinner> = mutableListOf()
        val intervalMap: MutableMap<String, IntervaloResponse> = mutableMapOf()

        splitProducersWinners(films, producerWinners)

        val producerWinnersGanhosConsecutivos: MutableList<ProducerWinner> = mutableListOf()

        consecutiveWinningProducers(producerWinners, producerWinnersGanhosConsecutivos)

        calculandoIntervalos(producerWinnersGanhosConsecutivos)

        val intervalMinimo: Int? = producerWinnersGanhosConsecutivos.minBy { it.interval!! }.interval

        val intervalMaximo: Int? = producerWinnersGanhosConsecutivos.maxBy { it.interval!! }.interval

        producersWinnerMaximoInterval(intervalMap, producerWinnersGanhosConsecutivos, intervalMaximo)

        producersWinnerMinimoInterval(intervalMap, producerWinnersGanhosConsecutivos, intervalMinimo)

        val intervaloResponsesMaximo: MutableList<IntervaloResponse> = mutableListOf()
        val intervaloResponsesMinimo: MutableList<IntervaloResponse> = mutableListOf()

        intervaloPremioResponses(intervaloPremioResponses, intervalMap, intervaloResponsesMaximo, intervaloResponsesMinimo)

        return intervaloPremioResponses
    }

    private fun intervaloPremioResponses(intervaloPremioResponses: IntervaloPremioResponse, intervalMap: MutableMap<String, IntervaloResponse,>, intervaloResponsesMaximo: MutableList<IntervaloResponse>, intervaloResponsesMinimo: MutableList<IntervaloResponse>) {
        intervalMap
            .forEach { (s, intervaloResponse) ->
                if (s.substring(0, s.indexOf("|")) == "max") {
                    intervaloResponsesMaximo.add(intervaloResponse)
                }
                if (s.substring(0, s.indexOf("|")) == "min") {
                    intervaloResponsesMinimo.add(intervaloResponse)
                }
            }

        intervaloPremioResponses.max = intervaloResponsesMaximo
        intervaloPremioResponses.min = intervaloResponsesMinimo
    }

    private fun producersWinnerMinimoInterval(intervalMap: MutableMap<String, IntervaloResponse>, producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>, intervalMinimo: Int?) {
        val producersWinnersIntervalMinimo: MutableList<ProducerWinner> = mutableListOf()
        producerWinnersGanhosConsecutivos
            .forEach { producerWinner ->
                if (producerWinner.interval == intervalMinimo) {
                    producersWinnersIntervalMinimo.add(producerWinner)
                }
            }

        restartingLogicalDelete(producersWinnersIntervalMinimo)

        producersWinnersIntervalMinimo
            .forEach { producerWinner ->
                val producerWinnerListMin2: MutableList<ProducerWinner> = mutableListOf()
                producersWinnersIntervalMinimo
                    .forEach { producerWinner1 ->
                        if (producerWinner1.producer == producerWinner.producer && !producerWinner1.delete!!) {
                            producerWinnerListMin2.add(producerWinner1)
                            producerWinner1.delete = true
                        }
                    }

                if (producerWinnerListMin2.size > 0) {
                    intervalMap.put("min|" + producerWinnerListMin2[0].producer, IntervaloResponse(
                        producerWinnerListMin2[0].producer,
                        producerWinnerListMin2[0].interval.toString(),
                        producerWinnerListMin2.minBy { it.year }.year.toString(),
                        producerWinnerListMin2.maxBy { it.year }.year.toString()
                    ))
                }
            }
    }

    private fun producersWinnerMaximoInterval(intervalMap: MutableMap<String, IntervaloResponse>, producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>, intervalMaximo: Int?) {
        val producersWinnersIntervalMaximo: MutableList<ProducerWinner> = mutableListOf()
        producerWinnersGanhosConsecutivos
            .forEach { producerWinner ->
                if (producerWinner.interval == intervalMaximo) {
                    producersWinnersIntervalMaximo.add(producerWinner)
                }
            }

        restartingLogicalDelete(producersWinnersIntervalMaximo)

        producersWinnersIntervalMaximo
            .forEach { producerWinner ->
                val producerWinnerListMax2: MutableList<ProducerWinner> = mutableListOf()
                producersWinnersIntervalMaximo
                    .forEach { producerWinner1 ->
                        if (producerWinner1.producer == producerWinner.producer && !producerWinner1.delete!!) {
                            producerWinnerListMax2.add(producerWinner1)
                            producerWinner1.delete = true
                        }
                    }

                if (producerWinnerListMax2.size > 0) {
                    intervalMap.put("max|" + producerWinnerListMax2[0].producer, IntervaloResponse(
                        producerWinnerListMax2[0].producer,
                        producerWinnerListMax2[0].interval.toString(),
                        producerWinnerListMax2.minBy { it.year }.year.toString(),
                        producerWinnerListMax2.maxBy { it.year }.year.toString()
                    )
                    )
                }
            }
    }

    private fun restartingLogicalDelete(producersWinnersIntervalMaximo: MutableList<ProducerWinner>) {
        producersWinnersIntervalMaximo
            .forEach { producerWinner -> producerWinner.delete = false }
    }

    private fun calculandoIntervalos(producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>) {
        producerWinnersGanhosConsecutivos.
                forEach { producerWinner ->
                    producerWinnersGanhosConsecutivos
                        .forEach { producerWinner1 ->
                            if (producerWinner1.producer == producerWinner.producer && producerWinner1.year != producerWinner.year) {
                                var internal: Int = producerWinner1.year - producerWinner.year
                                if (internal < 0) {
                                    internal *= - 1
                                }
                                producerWinner.interval = internal
                            }
                        }
                }
    }

    private fun consecutiveWinningProducers(producerWinners: MutableList<ProducerWinner>, producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>) {
        producerWinners
            .forEach { producerWinner ->
                val producerWinnersGanhosConsecutivosTemp: MutableList<ProducerWinner> = mutableListOf()
                producerWinners.forEach { producerWinner1 ->
                    if (producerWinner1.producer == producerWinner.producer && !producerWinner1.delete!!) {
                        producerWinnersGanhosConsecutivosTemp.add(producerWinner1)
                        producerWinner1.delete = true
                    }
                }

                if (producerWinnersGanhosConsecutivosTemp.size > 1) {
                    producerWinnersGanhosConsecutivos.addAll(producerWinnersGanhosConsecutivosTemp)
                }
            }
    }

    private fun splitProducersWinners(films: List<Film>, producerWinners: MutableList<ProducerWinner>) {
        films.forEach { film ->
            val producersList: List<String> = film.producers.split(",")

            val producers2List: List<String> = producersList
                .flatMap { it.replace(" and ", ",").split(",") }

            producers2List.forEach { producer -> producerWinners.add(ProducerWinner(
                year = film.year.toInt(),
                producer = producer
            )) }
        }
    }

}