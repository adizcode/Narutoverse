package com.github.adizcode.narutoverse.destinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.adizcode.narutoverse.R
import com.github.adizcode.narutoverse.databinding.FragmentCharacterDescriptionBinding

class CharacterDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentCharacterDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_character_description,
            container,
            false
        )

        // Retrieve and data bind the passed-in Character instance
        binding.character =
            CharacterDescriptionFragmentArgs.fromBundle(requireArguments()).character

        return binding.root
    }

}