package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class InstructionsFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val binding: FragmentInstructionsBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_instructions, container, false
            )
            binding.shoeListButton.setOnClickListener {
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeFragment())
            }

            return binding.root
        }

}