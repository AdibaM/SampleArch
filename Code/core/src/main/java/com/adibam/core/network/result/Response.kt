package com.adibam.core.network.result

sealed class Response<T> {

    data class Success<T>(val value: T) : Response<T>()

    data class Failure<T>(val throwable: Throwable) : Response<T>()
}
