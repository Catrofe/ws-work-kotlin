package com.wswork.brand.service

import com.wswork.brand.dto.RegisterBrandDTO
import com.wswork.brand.entity.Brand
import com.wswork.brand.repository.BrandRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@Service
@RequiredArgsConstructor
class BrandService(val repository: BrandRepository) {

    fun insert(brand: RegisterBrandDTO): Brand {
        val newBrand = Brand().apply() { nameBrand = brand.nameBrand }

        return repository.save(newBrand)
    }

    fun findById(id: Long): Brand {
        return repository.findById(id).orElseThrow { RuntimeException("Brand not found") }
    }

    fun findAll(): List<Brand> {
        return repository.findAll()
    }

    fun update(brand: RegisterBrandDTO, id: Long): Brand {
        val newBrand = findById(id)
        newBrand.nameBrand = brand.nameBrand
        return repository.save(newBrand)
    }

    fun delete(id: Long) {
        val brand = findById(id)
        repository.delete(brand)
    }

}
