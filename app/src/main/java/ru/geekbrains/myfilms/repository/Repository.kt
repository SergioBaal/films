package ru.geekbrains.myfilms.repository

interface Repository {
    fun getFilmFromServer():Film
    fun getFilmFromLocalStorage(): List<Film>

}