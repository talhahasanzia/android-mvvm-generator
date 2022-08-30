package com.example.myapplication.login.domain

import com.example.myapplication.common.BaseUseCase
import com.example.myapplication.login.api.LoginService
import com.example.myapplication.login.models.LoginRequest
import com.example.myapplication.login.models.LoginState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface LoginUseCase : BaseUseCase<LoginRequest, Flow<LoginState>>

class DefaultLoginUseCase @Inject constructor(
    private val service: LoginService,
) : LoginUseCase {

    override suspend fun execute(request: LoginRequest): Flow<LoginState> {
        return flow {
            emit(LoginState.Loading)


        }
    }
}