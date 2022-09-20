package com.project.disneycodechallenge_natnaelalemayehu.viewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.disneycodechallenge_natnaelalemayehu.databinding.GuestListItemBinding
import com.project.disneycodechallenge_natnaelalemayehu.model.Guest
import com.project.disneycodechallenge_natnaelalemayehu.ui.fragments.GuestListFragment.Companion.isExist

class ReservedGuestListViewAdapter(
    private val listItem: MutableList<Guest> = mutableListOf(),
    private val checkReservedGuestReservation: () -> Unit
) : RecyclerView.Adapter<ReservedGuestListViewAdapter.ReservedGuestListViewHolder>() {

    fun updateReservedLis(newList: List<Guest>) {
        listItem.clear()
        listItem.addAll(newList)
        notifyDataSetChanged()
    }

    inner class ReservedGuestListViewHolder(private val binding: GuestListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Guest) {
            binding.apply {
                txtName.text = item.name
            }

            binding.btnCheckBox.setOnCheckedChangeListener { _, isChecked ->
                isExist = isChecked

                checkReservedGuestReservation()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservedGuestListViewAdapter.ReservedGuestListViewHolder {
        return ReservedGuestListViewHolder(
            GuestListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReservedGuestListViewAdapter.ReservedGuestListViewHolder, position: Int) {
        holder.onBind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size
}