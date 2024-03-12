package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {


    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: LiveData<MutableList<Shoe>>
        get() = _shoesList
    fun shoeListEmpty(): Boolean {
        return _shoesList.value == null || _shoesList.value?.isEmpty() == true
    }

    fun addShoe(shoe: Shoe) {
        if (_shoesList.value == null) {
            _shoesList.value = mutableListOf(shoe)
        } else {
            _shoesList.value?.add(shoe)
        }
    }
}