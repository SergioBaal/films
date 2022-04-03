package ru.geekbrains.myfilms.repository

class RepositoryImpl : Repository {
    override fun getFilmFromServer(): Film {
       Thread.sleep(2000) // Эмуляция сетевого запроса.
        return Film()
    }

    override fun getFilmFromLocalStorage(): List<Film> {
        return getFilm()
    }
}