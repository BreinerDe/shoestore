package com.udacity.shoestore.screens.shoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()
    fun validateInput(): Boolean {
        return checkFieldsNotEmpty(
            shoeName,
            shoeSize,
            shoeCompany,
            shoeDescription
        )
    }

    fun createShoe(): Shoe {
        return Shoe(
            shoeName.value ?: "",
            convertShoeSize(),
            shoeCompany.value ?: "",
            shoeDescription.value ?: "",
            arrayListOf(""))
    }

    private fun checkFieldsNotEmpty(vararg strings: MutableLiveData<String>): Boolean {
        return strings.all { it.value?.isNotEmpty() == true }
    }
    private fun convertShoeSize():Double{
        if(!shoeSize.value.isNullOrEmpty()){
            return shoeSize.value!!.toDouble()
        }
        return 0.0
    }
}