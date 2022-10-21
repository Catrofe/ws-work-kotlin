package com.wswork.brand.controller

import com.wswork.brand.dto.RegisterBrandDTO
import com.wswork.brand.entity.Brand
import com.wswork.brand.service.BrandService
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
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
class BrandController(val service: BrandService) {

    @PostMapping
    fun save(@RequestBody @Valid brand: RegisterBrandDTO): ResponseEntity<Brand> {
        val newBrand = service.insert(brand)
        return ResponseEntity(newBrand, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Brand> {
        val brand = service.findById(id)
        return ResponseEntity(brand, HttpStatus.OK)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<Brand>> {
        val brands = service.findAll()
        return ResponseEntity(brands, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody @Valid brand: RegisterBrandDTO,
                @PathVariable id: Long): ResponseEntity<Brand> {
        val newBrand = service.update(brand, id)
        return ResponseEntity(newBrand, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
