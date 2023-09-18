package br.com.atarashi.goldenRaspberryAwardsKotlin.facade.impl

import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloPremioResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.controller.response.IntervaloResponse
import br.com.atarashi.goldenRaspberryAwardsKotlin.facade.FilmFacade
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film
import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.ProducerWinner
import org.springframework.stereotype.Service

@Service
class FilmFacadeImpl: FilmFacade {

    override fun intervaloPremio(films: List<Film>): IntervaloPremioResponse {
        val intervalMap: MutableMap<String, IntervaloResponse> = mutableMapOf()

        val producerWinnersGanhosConsecutivos = consecutiveWinningProducers(splitProducersWinners(films))

        calculandoIntervalos(producerWinnersGanhosConsecutivos)

        producersWinnerMaximoInterval(intervalMap, producerWinnersGanhosConsecutivos)

        producersWinnerMinimoInterval(intervalMap, producerWinnersGanhosConsecutivos)

        return intervaloPremioResponses(intervalMap)
    }

    private fun intervaloPremioResponses(intervalMap: MutableMap<String, IntervaloResponse>): IntervaloPremioResponse {
        val intervaloResponsesMaximo: MutableList<IntervaloResponse> = arrayListOf()
        val intervaloResponsesMinimo: MutableList<IntervaloResponse> = arrayListOf()

        intervalMap
            .forEach { (s, intervaloResponse) ->
                if (s.substring(0, s.indexOf("|")) == "max") {
                    intervaloResponsesMaximo.add(intervaloResponse)
                }
                if (s.substring(0, s.indexOf("|")) == "min") {
                    intervaloResponsesMinimo.add(intervaloResponse)
                }
            }

        return IntervaloPremioResponse(intervaloResponsesMinimo, intervaloResponsesMaximo)
    }

    private fun producersWinnerMinimoInterval(intervalMap: MutableMap<String, IntervaloResponse>, producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>) {
        val intervalMinimo: Int? = producerWinnersGanhosConsecutivos.minBy { it.interval!! }.interval
        val producersWinnersIntervalMinimo = arrayListOf<ProducerWinner>()

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

    private fun producersWinnerMaximoInterval(intervalMap: MutableMap<String, IntervaloResponse>, producerWinnersGanhosConsecutivos: MutableList<ProducerWinner>) {
        val intervalMaximo: Int? = producerWinnersGanhosConsecutivos.maxBy { it.interval!! }.interval
        val producersWinnersIntervalMaximo = arrayListOf<ProducerWinner>()

        producerWinnersGanhosConsecutivos
            .forEach { producerWinner ->
                if (producerWinner.interval == intervalMaximo) {
                    producersWinnersIntervalMaximo.add(producerWinner)
                }
            }

        restartingLogicalDelete(producersWinnersIntervalMaximo)

        producersWinnersIntervalMaximo
            .forEach { producerWinner ->
                val producerWinnerListMax2 = arrayListOf<ProducerWinner>()
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

    private fun consecutiveWinningProducers(producerWinners: MutableList<ProducerWinner>): MutableList<ProducerWinner> {
        val producerWinnersGanhosConsecutivos: MutableList<ProducerWinner> = mutableListOf()
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
        return producerWinnersGanhosConsecutivos
    }

    private fun splitProducersWinners(films: List<Film>): MutableList<ProducerWinner> {
        val producerWinners: MutableList<ProducerWinner> = mutableListOf()
        films.forEach { film ->
            val producersList: List<String> = film.producers.split(",").toList()

            val producers2List: List<String> = producersList
                .flatMap { it.replace(" and ", ",").split(",") }

            producers2List.forEach { producer -> producerWinners.add(ProducerWinner(
                year = film.year.toInt(),
                producer = producer
            )) }
        }
        return producerWinners
    }

}