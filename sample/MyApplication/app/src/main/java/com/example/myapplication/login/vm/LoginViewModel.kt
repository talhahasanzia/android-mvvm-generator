package com.example.myapplication.login.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.login.models.LoginRequest
import com.example.myapplication.login.models.LoginState
import com.example.myapplication.login.domain.LoginUseCase
import com.example.myapplication.resources.StringResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase,
    private val stringRes: StringResourceProvider
) :
    ViewModel() {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState>
        get() = _state

    fun getData() {
        viewModelScope.launch {
            useCase.execute(LoginRequest("")).collectLatest {

            }
        }
    }

}