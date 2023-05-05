package br.com.car

import br.com.car.domain.model.Car

object CarFixture {
    fun getCar() = Car(id = 1, name = "Gol", model = "VW", year = 2015)
}