package ru.geekbrains.myfilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.geekbrains.myfilms.repository.RepositoryImpl

class MainViewModel(
    private val liveData: MutableLiveData<AppState> = MutableLiveData(),
    private val repository: RepositoryImpl = RepositoryImpl()
) :

    ViewModel() {

        fun getData() : LiveData<AppState> = liveData

    private fun getFilm(){
        Thread {
            liveData.postValue(AppState.Loading)
            if ((1..10).random() < 5) {
                liveData.postValue(AppState.Success(repository.getFilmFromLocalStorage()))
            } else
                liveData.postValue(AppState.Error(IllegalAccessException()))

        }.start()
    }

}