package com.github.adizcode.narutoverse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.github.adizcode.narutoverse.R
import com.github.adizcode.narutoverse.databinding.CharactersGridItemBinding
import com.github.adizcode.narutoverse.destinations.CharactersGridFragmentDirections
import com.github.adizcode.narutoverse.model.Character

class CharactersGridAdapter(private val charactersList: List<Character>) :
    RecyclerView.Adapter<CharactersGridAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CharactersGridItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding =
            DataBindingUtil.inflate<CharactersGridItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.characters_grid_item,
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Current Character instance
        val character = charactersList[position]

        // Pass current instance to the new destination upon click
        val clickListener = { view: View ->
            view.findNavController().navigate(
                CharactersGridFragmentDirections.actionCharactersGridFragmentToCharacterOverviewFragment2(
                    character
                )
            )
        }

        // Bind data and click listener
        holder.binding.apply {
            this.character = character
            this.characterCard.setOnClickListener(clickListener)
        }
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }
}