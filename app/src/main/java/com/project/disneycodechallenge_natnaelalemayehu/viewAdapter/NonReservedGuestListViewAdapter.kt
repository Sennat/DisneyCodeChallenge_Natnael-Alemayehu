package com.project.disneycodechallenge_natnaelalemayehu.viewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.disneycodechallenge_natnaelalemayehu.databinding.GuestListItemBinding
import com.project.disneycodechallenge_natnaelalemayehu.model.Guest
import com.project.disneycodechallenge_natnaelalemayehu.ui.fragments.GuestListFragment.Companion.isExist

class NonReservedGuestListViewAdapter(
    private val listItem: MutableList<Guest> = mutableListOf(),
    private val checkNonReservedGuestReservation: (guest: Guest) -> Unit
) : RecyclerView.Adapter<NonReservedGuestListViewAdapter.NonReservedGuestListViewViewHolder>() {

    fun updateNonReservedLis(newList: List<Guest>) {
        listItem.clear()
        listItem.addAll(newList)
        notifyDataSetChanged()
    }

    inner class NonReservedGuestListViewViewHolder(private val binding: GuestListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Guest) {
            binding.apply {
                txtName.text = item.name
            }

            binding.btnCheckBox.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked){
                    isExist = false
                }
                checkNonReservedGuestReservation(item)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonReservedGuestListViewViewHolder {
        return NonReservedGuestListViewViewHolder(
            GuestListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NonReservedGuestListViewViewHolder, position: Int) {
        holder.onBind(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }
}