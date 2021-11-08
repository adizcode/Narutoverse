package com.github.adizcode.narutoverse.destinations

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.adizcode.narutoverse.R
import com.github.adizcode.narutoverse.databinding.FragmentCharacterOverviewBinding
import timber.log.Timber

class CharacterOverviewFragment : Fragment() {
    private lateinit var binding: FragmentCharacterOverviewBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        Timber.i("onCreateView")

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.i("onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("onDetach")
    }

}