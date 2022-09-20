package com.project.disneycodechallenge_natnaelalemayehu.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.disneycodechallenge_natnaelalemayehu.databinding.FragmentConfirmationBinding

class ConfirmationFragment : BaseFragment() {

    private lateinit var binding : FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmationBinding.inflate(layoutInflater)

        return binding.root
    }

}