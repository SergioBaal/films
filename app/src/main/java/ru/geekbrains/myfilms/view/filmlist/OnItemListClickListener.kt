package ru.geekbrains.myfilms.view.filmlist

import ru.geekbrains.myfilms.repository.Film

interface OnItemListClickListener {
    fun onItemClick(film: Film)
}