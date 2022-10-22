package com.wswork.brand.service

import com.wswork.brand.dto.RegisterBrandDTO
import com.wswork.brand.entity.Brand
import com.wswork.brand.repository.BrandRepository
import com.wswork.utils.exception.ConflictException
import com.wswork.utils.exception.NotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class BrandService(val repository: BrandRepository) {

    fun insert(brand: RegisterBrandDTO): Brand {
        val newBrand = Brand().apply() { nameBrand = brand.nameBrand }

        return repository.save(newBrand)
    }

    fun findById(id: Long): Brand {
        return repository.findById(id).orElseThrow { NotFoundException(String.format("Brand with id %d not found", id)) }
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
        try {
            repository.delete(brand)
        } catch (e: Exception) {
            throw ConflictException(String.format("Unable to delete a Brand that has Models associated with it. Please delete Models first to ensure data integrity. Brand id: %d", id))
        }
    }

}
