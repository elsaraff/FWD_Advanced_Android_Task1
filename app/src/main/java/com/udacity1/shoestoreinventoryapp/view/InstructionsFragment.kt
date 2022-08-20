package com.udacity1.shoestoreinventoryapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity1.shoestoreinventoryapp.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    private lateinit var  binding : FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInstructionsBinding.inflate(LayoutInflater.from(requireContext()))

        binding.nextBt2.setOnClickListener{
            loggedInStatus()
            this.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment())
        }

        return binding.root
    }

    private fun loggedInStatus(){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref!!.edit()) {
            putBoolean("loggedIn",true).apply().apply {
                Toast.makeText(context,"Logged in",Toast.LENGTH_SHORT).show()
            }
        }
    }

}