package com.github.adizcode.narutoverse.destinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.github.adizcode.narutoverse.R
import com.github.adizcode.narutoverse.adapter.CharactersGridAdapter
import com.github.adizcode.narutoverse.databinding.FragmentCharactersGridBinding
import com.github.adizcode.narutoverse.model.Character

class CharactersGridFragment : Fragment() {

    private lateinit var binding: FragmentCharactersGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_characters_grid,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = CharactersGridAdapter(getCharactersList())
        }
    }

    private fun getCharactersList(): List<Character> {
        resources.apply {
            val names = getStringArray(R.array.names)

            val characters = mutableListOf<Character>()

            // TODO: Remove hard-coded data and add via JSON files

            for (index in names.indices) {
                characters.add(
                    Character(
                        name = names[index],
                        imageResource = R.drawable.ic_launcher_background,
                        quote = "Temp Quote",
                        description = "Temp Description"
                    )
                )
            }

            return characters
        }
    }
}