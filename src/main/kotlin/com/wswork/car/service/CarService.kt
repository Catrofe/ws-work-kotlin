package com.wswork.car.service

import com.wswork.car.dto.EditCarDTO
import com.wswork.car.dto.RegisterCarDTO
import com.wswork.car.entity.Car
import com.wswork.car.repository.CarRepository
import com.wswork.car.vo.CarVO
import com.wswork.model.service.ModelService
import com.wswork.utils.exception.NotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.TimeZone

@Service
@RequiredArgsConstructor
class CarService(val repository: CarRepository,
                 val modelService: ModelService) {

    fun returnVO(car: Car): CarVO {
        val model = car.model
        val brand = model?.brand
        return CarVO().apply {
            id = car.id
            marca_id = brand?.id
            marca_nome = brand?.nameBrand
            nome_modelo = model?.name
            ano = car.year
            combustivel = car.fuel
            num_portas = car.numberDoors
            valor_fipe = model?.valueFipe
            cor = car.color
            timestamp_cadastro = car.timestampRegistration }
    }

    fun insert(car: RegisterCarDTO): CarVO {
        val findModel = car.modelId?.let { modelService.findByIdRaw(it) }
        var newCar = Car().apply {
            timestampRegistration = Calendar.getInstance().timeInMillis
            model = findModel
            year = car.year
            fuel = car.fuel
            numberDoors = car.numberDoors
            color = car.color
        }
        newCar = repository.save(newCar)
        return returnVO(newCar)
    }

    fun findById(id: Long): CarVO {
        val car = repository.findById(id).orElseThrow { NotFoundException(String.format("Car with id %d not found", id)) }
        return returnVO(car)
    }

    fun findAll(): List<CarVO> {
        val cars = repository.findAll()
        return cars.map { returnVO(it) }
    }

    fun findByIdRaw(id: Long): Car {
        return repository.findById(id).orElseThrow { NotFoundException(String.format("Car with id %d not found", id)) }
    }

    fun update(id: Long, editCar: EditCarDTO): CarVO {

        var findCar = findByIdRaw(id)
        if (editCar.modelId != null) {
            findCar.model = editCar.modelId?.let { modelService.findByIdRaw(it) }
        }
        if (editCar.year != null) findCar.year = editCar.year
        if (editCar.fuel != null) findCar.fuel = editCar.fuel
        if (editCar.numberDoors != null) findCar.numberDoors = editCar.numberDoors
        if (editCar.color != null) findCar.color = editCar.color

        findCar = repository.save(findCar)
        return returnVO(findCar)

    }

    fun delete(id: Long) {
        val findCar = findByIdRaw(id)
        repository.delete(findCar)
    }
}