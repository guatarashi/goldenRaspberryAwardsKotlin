package br.com.atarashi.goldenRaspberryAwardsKotlin.repository.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "\"FILM\"")
data class Film(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Column(name = "\"year\"")
    val year: String,
    @Column(name = "title")
    val title: String,
    @Column(name = "studios")
    val studios: String,
    @Column(name = "producers")
    val producers: String,
    @Column(name = "winner")
    val winner: String
)
