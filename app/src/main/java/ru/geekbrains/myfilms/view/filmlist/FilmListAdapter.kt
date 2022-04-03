package ru.geekbrains.myfilms.view.filmlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrains.myfilms.databinding.FragmentFilmListRecyclrerItemBinding
import ru.geekbrains.myfilms.repository.Film

class FilmListAdapter(
    private val onItemListClickListener: OnItemListClickListener,
    private var data: List<Film> = listOf()
) :
    RecyclerView.Adapter<FilmListAdapter.FilmHolder>() {


    fun setData(dataNew: List<Film>) {
        this.data = dataNew
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val binding = FragmentFilmListRecyclrerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FilmHolder(binding.root)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount() = data.size




    inner class FilmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(film: Film) {
            val binding = FragmentFilmListRecyclrerItemBinding.bind(itemView)
            binding.tvFilmName.text = film.name
            binding.root.setOnClickListener {
                onItemListClickListener.onItemClick(film)
            }
        }
    }
}