package com.udacity1.shoestoreinventoryapp.repository

import com.udacity1.shoestoreinventoryapp.model.Shoe

class ShoeRepository{

    //Dummy data
    fun getShoesData(): ArrayList<Shoe> {

        val shoe1 = Shoe("Air Max", "Nike", 40.0, "A joy to run in.")
        val shoe2 = Shoe("Supernova", "Adidas", 42.0, "Hugs your feet.")

        return arrayListOf(shoe1, shoe2)
    }

}