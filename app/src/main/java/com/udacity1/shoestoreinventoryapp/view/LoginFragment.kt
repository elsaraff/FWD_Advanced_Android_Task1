package com.udacity1.shoestoreinventoryapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity1.shoestoreinventoryapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var  binding : FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        binding = FragmentLoginBinding.inflate(LayoutInflater.from(requireContext()))

        binding.loginBt.setOnClickListener{
            login()
            //this.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        /*binding.signupBt.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )*/

        binding.signupBt.setOnClickListener{
            this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }

    private fun login() {
        with(binding) {
            val email = editTextLoginEmail.text
            val password = editTextLoginPassword.text

            Log.d("LOGIN", "$email $password")
        }
    }
}