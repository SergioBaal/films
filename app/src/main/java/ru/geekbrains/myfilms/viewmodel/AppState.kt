package ru.geekbrains.myfilms.viewmodel

import ru.geekbrains.myfilms.repository.Film

sealed class AppState {
    object Loading:AppState()
    data class Success(val filmList: List<Film>):AppState()
    data class Error(val error: Throwable):AppState()
}