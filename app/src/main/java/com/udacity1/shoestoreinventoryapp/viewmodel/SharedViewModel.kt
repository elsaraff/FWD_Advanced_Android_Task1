package com.udacity1.shoestoreinventoryapp.viewmodel
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity1.shoestoreinventoryapp.model.Shoe
import com.udacity1.shoestoreinventoryapp.repository.ShoeRepository

open class SharedViewModel: ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>

        get() = _shoes

    fun addShoe(view:View, shoe: Shoe){
        if (shoe.name.isEmpty()||shoe.company.isEmpty()||
            shoe.size.isNaN()||shoe.description.isEmpty())
        {
            Toast.makeText(view.context,"Please Enter Shoe Data First!",Toast.LENGTH_SHORT).show()
        }
        else {
            _shoes.value?.add(shoe)
            navigateUp(view)
        }
    }

    init {
        getShoes()
    }

    private fun getShoes(){
        _shoes.value = ShoeRepository().getShoesData()
    }

    fun navigateUp(view: View){
        view.findNavController().navigateUp()
    }
}