package it.altamuraieri.data.exception

import java.lang.RuntimeException

abstract class EntityNotFoundException(msg: String): RuntimeException(msg)