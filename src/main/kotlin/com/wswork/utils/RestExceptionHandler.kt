package com.wswork.utils

import com.wswork.utils.exception.ConflictException
import com.wswork.utils.exception.ExceptionDetails
import com.wswork.utils.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleGenericException(ex: NotFoundException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(ExceptionDetails(ex.message!!, 404), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(ConflictException::class)
    fun handleConflictException(ex: ConflictException): ResponseEntity<ExceptionDetails> {
        return ResponseEntity(ExceptionDetails(ex.message!!, 409), HttpStatus.CONFLICT)
    }
}
