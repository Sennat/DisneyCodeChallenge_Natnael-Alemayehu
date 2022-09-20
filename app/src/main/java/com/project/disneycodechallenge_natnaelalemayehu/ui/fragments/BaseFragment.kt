package com.project.disneycodechallenge_natnaelalemayehu.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.project.disneycodechallenge_natnaelalemayehu.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    protected val mainViewModel : MainViewModel by  activityViewModels()
}