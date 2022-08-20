package com.udacity1.shoestoreinventoryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity1.shoestoreinventoryapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var  binding : FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentWelcomeBinding.inflate(LayoutInflater.from(requireContext()))

        binding.nextBt.setOnClickListener{
            this.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        return binding.root
    }
}