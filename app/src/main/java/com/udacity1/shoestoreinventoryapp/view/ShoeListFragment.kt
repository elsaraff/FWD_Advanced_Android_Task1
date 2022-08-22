package com.udacity1.shoestoreinventoryapp.view

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.udacity1.shoestoreinventoryapp.R
import com.udacity1.shoestoreinventoryapp.databinding.FragmentShoeListBinding
import com.udacity1.shoestoreinventoryapp.databinding.ItemShoeBinding
import com.udacity1.shoestoreinventoryapp.viewmodel.SharedViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentShoeListBinding.inflate(LayoutInflater.from(requireContext()))

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.logout -> {
                        loggedOutStatus()
                        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
                        true
                    }
                    else -> false
                }
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Get a reference to the ViewModel scoped to this Fragment
        //val sharedViewModel by viewModels<SharedViewModel>()

        // Get a reference to the ViewModel scoped to its Activity
        val sharedViewModel by activityViewModels<SharedViewModel>()

        sharedViewModel.shoes.observe(this.viewLifecycleOwner) {
            for (shoe in it) {

                DataBindingUtil.inflate<ItemShoeBinding>(
                    layoutInflater,
                    R.layout.item_shoe,
                    binding.shoeList,
                    true
                ).apply {
                    this.shoe = shoe
                }
            }
        }

        binding.floatingActionButton.setOnClickListener{
            this.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailShoeFragment())
        }

        return binding.root
    }
    private fun loggedOutStatus(){
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
        with (sharedPref!!.edit()) {
            putBoolean("loggedIn",false).apply().apply {
                Toast.makeText(context,"Logged out", Toast.LENGTH_SHORT).show()
            }
        }
    }
}