package com.project.disneycodechallenge_natnaelalemayehu.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.project.disneycodechallenge_natnaelalemayehu.R
import com.project.disneycodechallenge_natnaelalemayehu.databinding.FragmentGuestListBinding
import com.project.disneycodechallenge_natnaelalemayehu.model.Guest
import com.project.disneycodechallenge_natnaelalemayehu.viewAdapter.NonReservedGuestListViewAdapter
import com.project.disneycodechallenge_natnaelalemayehu.viewAdapter.ReservedGuestListViewAdapter
import kotlin.properties.Delegates

class GuestListFragment : BaseFragment() {

    private lateinit var binding: FragmentGuestListBinding
    private val reservedGuestListViewAdapter by lazy { ReservedGuestListViewAdapter( checkReservedGuestReservation = ::checkReservedGuestReservation) }
    private val nonReservedGuestListViewAdapter by lazy {NonReservedGuestListViewAdapter(checkNonReservedGuestReservation = ::checkNonReservedGuestReservation)
    }
   // private var isExist by Delegates.notNull<Boolean>()

    companion object{
        var isExist: Boolean = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGuestListBinding.inflate(layoutInflater)

        //isExist = false
        binding.btnContinue.setOnClickListener { performReservation() }
        initViewModel()
        return binding.root
    }

    private fun initViewModel() {
        mainViewModel.reservedGuestsLiveData.observe(viewLifecycleOwner) {
            binding.apply {
                reservedGuestListViewAdapter.updateReservedLis(it as List<Guest>)
                recViewReserved.adapter = reservedGuestListViewAdapter
            }
        }

        mainViewModel.nonReservedGuestsLiveData.observe(viewLifecycleOwner) {
            binding.apply {
                nonReservedGuestListViewAdapter.updateNonReservedLis(it as List<Guest>)
                recViewNonReserved.adapter = nonReservedGuestListViewAdapter
            }
        }
    }

    private fun checkReservedGuestReservation() {
        if (isExist) {
            binding.txtError.visibility = View.GONE
        }
    }

    private fun checkNonReservedGuestReservation(guest: Guest) {
        mainViewModel.reservedGuestsLiveData.observe(viewLifecycleOwner) {
            isExist = (it.isNotEmpty() && it.contains(guest))
        }
        if (!isExist) {
            binding.txtError.visibility = View.GONE
        }
    }

    private fun performReservation() {
        if (!isExist) {
            binding.apply {
                txtError.error = getString(R.string.error_msg)
                txtError.visibility = View.VISIBLE
            }
        } else {
            binding.txtError.visibility = View.GONE
            findNavController().navigate(GuestListFragmentDirections.actionGuestListFragmentToConfirmationFragment())
        }
    }
}