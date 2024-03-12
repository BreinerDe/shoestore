package com.udacity.shoestore.screens.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.ViewShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoelistBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.fab.setOnClickListener {
           findNavController().navigate(ShoeListFragmentDirections.actionShoeFragmentToShoeDetailFragment())
        }

        viewModel.shoesList.observe(viewLifecycleOwner) { shoesList ->
            for (shoe in shoesList) {
                addShoeToView(container, shoe)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }
    private fun addShoeToView(
        container: ViewGroup?,
        shoe: Shoe
    ) {
        val shoeBinding: ViewShoeBinding = DataBindingUtil.inflate(
           layoutInflater, R.layout.view_shoe, container, false
      )
       shoeBinding.shoe = shoe
        binding.shoeListLinearLayout.addView(shoeBinding.root)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeFragmentToLogin())
        return true
    }
}