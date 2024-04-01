package com.example.superheroapp.presentation.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val mainAdapter: MainAdapter by lazy { MainAdapter() }

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHeroesList()

        viewModel.heroesList.observe(viewLifecycleOwner) { heroes ->

            mainAdapter.setHeroList(heroes)
        }

        binding.rvSuperHero.layoutManager = LinearLayoutManager(context)
        binding.rvSuperHero.adapter = mainAdapter

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}