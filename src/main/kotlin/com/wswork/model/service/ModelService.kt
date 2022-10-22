package com.wswork.model.service

import com.wswork.brand.service.BrandService
import com.wswork.model.dto.CreateModelDTO
import com.wswork.model.dto.EditModelDTO
import com.wswork.model.entity.Model
import com.wswork.model.repository.ModelRepository
import com.wswork.model.vo.ModelVO
import com.wswork.utils.exception.ConflictException
import com.wswork.utils.exception.NotFoundException
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ModelService(val repository: ModelRepository,
                   val brandService: BrandService) {

    fun returnVO(model: Model): ModelVO {
        return ModelVO().apply { id = model.id
                                nameBrand = model.brand?.nameBrand
                                idBrand = model.brand?.id
                                name = model.name
                                valueFipe = model.valueFipe }
    }

    fun insert(model: CreateModelDTO): ModelVO {
        val findBrand = model.brandId?.let { brandService.findById(it) }
        var newModel = Model().apply { name = model.name; valueFipe = model.valueFipe; brand = findBrand }
        newModel = repository.save(newModel)
        return returnVO(newModel)
    }

    fun findById(id: Long): ModelVO {
        val model = repository.findById(id).orElseThrow { NotFoundException(String.format("Model with id %d not found", id)) }
        return returnVO(model)
    }

    fun findAll(): List<ModelVO> {
        val models = repository.findAll()
        return models.map { returnVO(it) }
    }

    fun findByIdRaw(id: Long): Model {
        return repository.findById(id).orElseThrow { NotFoundException(String.format("Model with id %d not found", id)) }
    }

    fun update(editModel: EditModelDTO, id: Long): ModelVO {
        var model = findByIdRaw(id)
        if (editModel.name != null) model.name = editModel.name
        if (editModel.valueFipe != null) model.valueFipe = editModel.valueFipe
        if (editModel.brandId != null) {
            model.brand = editModel.brandId?.let { brandService.findById(it) }
        }
        model = repository.save(model)
        return returnVO(model)
    }

    fun delete(id: Long) {
        val model = findByIdRaw(id)
        try {
            repository.delete(model)
        } catch (e: Exception) {
            throw ConflictException(String.format("Unable to delete a Model that has Cars associated with it. Please delete Cars first to ensure data integrity. Model id: %d", id))
        }
    }
}

