package com.wswork.utils.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

class NotFoundException(override val message: String?) : Exception(message)