package com.aaron.bankaccount.screenstate

sealed class UIState{
    object Success: UIState()
    object Loading: UIState()
    object Error: UIState()
}


