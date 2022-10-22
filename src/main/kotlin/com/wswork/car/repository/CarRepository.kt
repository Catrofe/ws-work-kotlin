package com.wswork.car.repository

import com.wswork.car.entity.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository: JpaRepository<Car, Long> {
}
