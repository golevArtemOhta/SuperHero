package com.example.superheroapp.presentation.description

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.superheroapp.R
import com.example.superheroapp.databinding.FragmentDescriptionBinding
import com.example.superheroapp.databinding.FragmentMainBinding
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.presentation.Main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DescriptionFragment : Fragment() {
    lateinit var binding: FragmentDescriptionBinding
    private val viewModel by viewModel<DescriptionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.action_descriptionFragment_to_mainFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionBinding.inflate(inflater)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val heroId = arguments?.getInt("ID")
        if (heroId != null) {
            viewModel.getHeroById((heroId-1))
        }

        viewModel.hero.observe(viewLifecycleOwner) { heroes ->
            with(binding){
                imgHeroDesc.load(R.drawable.hero_example)
                tvHeroName.text = heroes.localized_name
                tvAttackTypeHero.text = heroes.attack_type
                var roles = heroes.roles.joinToString(", ")
                tvRolesHero.text = roles
            }

        }


    }


    companion object {

        @JvmStatic
        fun newInstance() = DescriptionFragment()

    }
}