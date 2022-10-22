package com.wswork.model.repository

import com.wswork.model.entity.Model
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ModelRepository: JpaRepository<Model, Long> {
}
