package com.udacity1.shoestoreinventoryapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.udacity1.shoestoreinventoryapp.databinding.FragmentDetailShoeBinding
import com.udacity1.shoestoreinventoryapp.model.Shoe
import com.udacity1.shoestoreinventoryapp.viewmodel.SharedViewModel

class DetailShoeFragment : Fragment() {

    private lateinit var binding: FragmentDetailShoeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentDetailShoeBinding.inflate(LayoutInflater.from(requireContext()))

        //sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val sharedViewModel by activityViewModels<SharedViewModel>()

        binding.sharedViewModel = sharedViewModel
        binding.shoe= Shoe("","",0.0,"")

        return binding.root
    }

}