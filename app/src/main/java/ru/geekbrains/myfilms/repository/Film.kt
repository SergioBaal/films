package ru.geekbrains.myfilms.repository

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val name:String = "",
    val picture: Int = 0,
    val shortDescription: String = "",
    val rating: Int = 0
) : Parcelable

fun getFilm(): List<Film> {
    return listOf(
        Film("1",1,"1",1)
    )
}
