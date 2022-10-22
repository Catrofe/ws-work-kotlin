package com.wswork.model.controller

import com.wswork.model.dto.CreateModelDTO
import com.wswork.model.dto.EditModelDTO
import com.wswork.model.service.ModelService
import com.wswork.model.vo.ModelVO
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
@RequestMapping("/model")
@RequiredArgsConstructor
class ModelController(var service: ModelService) {

    @PostMapping
    fun save(@RequestBody @Valid model: CreateModelDTO): ResponseEntity<ModelVO> {
        val newModel = service.insert(model)
        return ResponseEntity(newModel, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<ModelVO> {
        val model = service.findById(id)
        return ResponseEntity(model, HttpStatus.OK)
    }

    @GetMapping
    fun findAll(): ResponseEntity<List<ModelVO>> {
        val models = service.findAll()
        return ResponseEntity(models, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody @Valid model: EditModelDTO,
                @PathVariable id: Long): ResponseEntity<ModelVO> {
        val newModel = service.update(model, id)
        return ResponseEntity(newModel, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}
