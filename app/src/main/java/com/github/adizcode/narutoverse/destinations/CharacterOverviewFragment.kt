package com.github.adizcode.narutoverse.destinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.adizcode.narutoverse.R
import com.github.adizcode.narutoverse.databinding.FragmentCharacterOverviewBinding

class CharacterOverviewFragment : Fragment() {
    private lateinit var binding: FragmentCharacterOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_character_overview,
            container,
            false
        )

        // Retrieve and data bind the passed-in Character instance
        binding.character = CharacterOverviewFragmentArgs.fromBundle(requireArguments()).character

        // Pass the Character instance to the next destination upon click
        val clickListener = { view: View ->
            view.findNavController().navigate(
                CharacterOverviewFragmentDirections.actionCharacterOverviewFragmentToCharacterDescriptionFragment(
                    binding.character!!
                )
            )
        }

        // Bind click listener
        binding.readMoreButton.setOnClickListener(clickListener)

        return binding.root
    }

}