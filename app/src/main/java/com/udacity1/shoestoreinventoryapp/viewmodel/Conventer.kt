package com.udacity1.shoestoreinventoryapp.viewmodel

import androidx.databinding.InverseMethod as AndroidxDatabindingInverseMethod


object Converter {
    @AndroidxDatabindingInverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(value: Double): String
    {
        return value.toString()
    }

    @JvmStatic fun stringToDouble(value: String): Double
    {
        return value.toDouble()
    }
}