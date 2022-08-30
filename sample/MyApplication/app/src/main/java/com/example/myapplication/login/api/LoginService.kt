package com.example.myapplication.login.api


import com.example.myapplication.login.models.LoginRequest
import com.example.myapplication.login.models.LoginRequestDto
import com.example.myapplication.login.models.LoginResponse
import com.example.myapplication.network.BaseService
import com.example.myapplication.network.Resource
import com.example.myapplication.resources.StringResourceProvider
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface LoginService {
    suspend fun get(request: LoginRequest): Resource<out LoginResponse>
}

class DefaultLoginService @Inject constructor(
    private val api: LoginApi,
    private val dispatcher: CoroutineDispatcher,
    private val stringResourceProvider: StringResourceProvider
) : LoginService, BaseService(dispatcher, stringResourceProvider) {

    override suspend fun get(request: LoginRequest): Resource<out LoginResponse> {
        return requestApiResource { api.getLogin(LoginRequestDto(request.data)) }
    }
}