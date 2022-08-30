package com.example.myapplication.common

interface BaseUseCase<Input, Output> {
    suspend fun execute(input: Input): Output
}