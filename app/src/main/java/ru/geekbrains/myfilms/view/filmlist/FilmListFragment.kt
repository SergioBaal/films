package ru.geekbrains.myfilms.view.filmlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import ru.geekbrains.myfilms.databinding.FragmentFilmListBinding
import ru.geekbrains.myfilms.repository.Film
import ru.geekbrains.myfilms.viewmodel.AppState


class FilmListFragment : Fragment(), OnItemListClickListener {

    private val adapter = FilmListAdapter(this)
    private var _binding: FragmentFilmListBinding? = null
    private val binding: FragmentFilmListBinding
        get() {
            return _binding!!
        }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRecycler () {
        binding.recyclerView.adapter = adapter
        val observer = object : Observer<AppState> {
            override fun onChanged(data: AppState) {
                renderData(data)
            }

        }
    }

    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Error -> {
                Snackbar.make(binding.root, "213", Snackbar.LENGTH_LONG).show()
            }
        }
    }


    override fun onItemClick(film: Film) {
        TODO("Not yet implemented")
    }
}