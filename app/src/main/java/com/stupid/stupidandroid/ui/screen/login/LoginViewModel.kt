package com.stupid.stupidandroid.ui.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stupid.stupidandroid.usecase.RegisterKakaoTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val registerKakaoTokenUseCase : RegisterKakaoTokenUseCase
) : ViewModel() {
    private val _loginSuccessEvent = MutableSharedFlow<Unit>()
    val loginSuccessEvent: SharedFlow<Unit> = _loginSuccessEvent.asSharedFlow()

    fun registerKakaoToken(token : String) {
        viewModelScope.launch {
            registerKakaoTokenUseCase(token)
                .catch {
                    Log.e("LoginViewModel",it.message.toString())
                }
                .collect {
                    _loginSuccessEvent.emit(Unit)
                }
        }
    }
}
