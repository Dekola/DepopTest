package com.dekola.dekoladepoptest.characters.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation
import com.dekola.dekoladepoptest.databinding.ListCharaterNameBinding

class CharacterNameAdapter :
    ListAdapter<CharacterPresentation, CharacterNameViewHolder>(CharacterNameDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterNameViewHolder {
        val binding: ListCharaterNameBinding =
            ListCharaterNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterNameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterNameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CharacterNameDiffUtil : DiffUtil.ItemCallback<CharacterPresentation>() {
        override fun areItemsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation,
        ): Boolean {
            return newItem == oldItem
        }

        override fun areContentsTheSame(
            oldItem: CharacterPresentation,
            newItem: CharacterPresentation,
        ): Boolean {
            return newItem == oldItem
        }

    }

}

class CharacterNameViewHolder(private val binding: ListCharaterNameBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(characterPresentation: CharacterPresentation?) {
        with(binding) {
            characterNameTv.text = characterPresentation?.characterName ?: "N/A"
        }
    }

}