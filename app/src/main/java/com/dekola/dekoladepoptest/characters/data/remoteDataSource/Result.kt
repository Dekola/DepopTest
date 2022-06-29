package com.dekola.dekoladepoptest.characters.data.remoteDataSource

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val errorMessage: String) : Result<Nothing>()
}