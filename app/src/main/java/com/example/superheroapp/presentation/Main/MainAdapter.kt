package com.example.superheroapp.presentation.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.superheroapp.R
import com.example.superheroapp.databinding.ItemSuperHeroBinding
import com.example.superheroapp.domain.model.HeroItem
import com.example.superheroapp.utils.Constants.BASE_URL

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private val list = mutableListOf<HeroItem>()
    class MainHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemSuperHeroBinding.bind(item)

        fun bind(hero: HeroItem) = with(binding) {
            //imgHeroItem.load("https://api.opendota.com${hero.icon}")
            imgHeroItem.load(R.drawable.hero_example)
            tvHeroItem.text = hero.localized_name

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("ID", hero.id)
                itemView.findNavController().navigate(R.id.action_mainFragment_to_descriptionFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_super_hero, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setHeroList(heroList: List<HeroItem>?) {
        list.clear()
        list.addAll(heroList!!)
        notifyDataSetChanged()
    }

}