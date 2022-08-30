package com.example.myapplication.login.di

import com.example.myapplication.login.api.LoginService
import com.example.myapplication.login.api.DefaultLoginService
import com.example.myapplication.login.domain.LoginUseCase
import com.example.myapplication.login.domain.DefaultLoginUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginBindings {

    @Binds
    abstract fun bindLoginService(default: DefaultLoginService): LoginService

    @Binds
    abstract fun bindLoginUseCase(default: DefaultLoginUseCase): LoginUseCase
}