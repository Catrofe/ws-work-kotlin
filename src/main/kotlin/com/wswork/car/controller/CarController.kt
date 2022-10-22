package com.wswork.car.controller

import com.wswork.car.dto.EditCarDTO
import com.wswork.car.dto.RegisterCarDTO
import com.wswork.car.service.CarService
import com.wswork.car.vo.CarVO
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
class CarController(val service: CarService) {

    @PostMapping
    fun save(@RequestBody @Valid car: RegisterCarDTO): ResponseEntity<CarVO> {
        val newCar = service.insert(car)
        return ResponseEntity(newCar, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CarVO> {
        val car = service.findById(id)
        return ResponseEntity(car, HttpStatus.OK)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<CarVO>> {
        val cars = service.findAll()
        return ResponseEntity(cars, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody @Valid car: EditCarDTO, @PathVariable id: Long): ResponseEntity<CarVO> {
        val updatedCar = service.update(id, car)
        return ResponseEntity(updatedCar, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}