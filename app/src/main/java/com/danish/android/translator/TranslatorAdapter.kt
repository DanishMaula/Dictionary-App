package com.danish.android.translator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danish.android.translator.data.DefinitionsItem
import com.danish.android.translator.data.ResponseItem
import com.danish.android.translator.databinding.RowDefinitionBinding

class TranslatorAdapter(): RecyclerView.Adapter<TranslatorAdapter.TranslatorViewHolder>() {
    private val listTranslator = ArrayList<DefinitionsItem>()

    class TranslatorViewHolder(val binding: RowDefinitionBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TranslatorViewHolder (
        RowDefinitionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: TranslatorViewHolder, position: Int) {
        holder.binding.apply {
            tvDefinition.text =
                listTranslator[position].definition ?: ""
        }
    }

    fun setData(data: List<DefinitionsItem>){
        listTranslator.clear()
        listTranslator.addAll(data)
    }

    override fun getItemCount(): Int {
        return listTranslator.size
    }
}