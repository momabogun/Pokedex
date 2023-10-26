package com.example.pokedex.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pokedex.PokeViewModel
import com.example.pokedex.databinding.FragmentLoadingBinding


class LoadingFragment : Fragment() {
    private lateinit var binding: FragmentLoadingBinding
    private val viewmodel: PokeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoadingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val loadingBar = binding.loadingPB


        loadingBar.max = 200

        viewmodel.count.observe(viewLifecycleOwner){
            val progress = it
            loadingBar.progress = progress
            if (progress == 200){
                findNavController().navigate(LoadingFragmentDirections.actionLoadingFragmentToHomeFragment())
            }
        }














    }




    }