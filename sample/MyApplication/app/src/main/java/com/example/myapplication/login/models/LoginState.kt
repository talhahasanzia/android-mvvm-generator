package com.example.myapplication.login.models

sealed class LoginState {
    data class Success(val data: String) : LoginState()
    data class Failure(val data: String) : LoginState()
    object Loading : LoginState()
}