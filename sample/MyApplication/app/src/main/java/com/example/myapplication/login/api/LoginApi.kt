package com.example.myapplication.login.api

import com.example.myapplication.login.models.LoginRequestDto
import com.example.myapplication.login.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface LoginApi {
    @GET("resource")
    suspend fun getLogin(
        @Body body: LoginRequestDto,
    ): LoginResponse
}