package br.com.atarashi.goldenRaspberryAwardsKotlin.repository

import br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model.Film
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface FilmRepository: JpaRepository<Film, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO film (`year`, title, studios, producers, winner) " +
            "VALUES (:#{#film.year},:#{#film.title},:#{#film.studios},:#{#film.producers},:#{#film.winner})", nativeQuery = true)
    fun insert(film: Film)

    @Modifying
    @Transactional
    @Query(value = "delete from film where id = :id", nativeQuery = true)
    fun delete(@Param("id") id: Int)

    @Query(value = "SELECT * FROM film f order by `year`", nativeQuery = true)
    override fun findAll(): List<Film>

    @Query(value = "SELECT * FROM film f where id = :id order by `year`", nativeQuery = true)
    fun findId(@Param("id") id: Int): Film

    @Query(value = "SELECT * FROM film f where winner = 'yes'", nativeQuery = true)
    fun findByWinner(): List<Film>
}