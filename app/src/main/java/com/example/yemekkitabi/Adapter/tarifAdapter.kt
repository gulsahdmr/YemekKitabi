package com.example.yemekkitabi.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemekkitabi.Model.Tarif
import com.example.yemekkitabi.View.ListeFragmentDirections
import com.example.yemekkitabi.databinding.RecyclerRowBinding

class tarifAdapter(val tarifListesi:List<Tarif>) :RecyclerView.Adapter<tarifAdapter.tarifHolder>(){
    class tarifHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tarifHolder {
val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return tarifHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
return tarifListesi.size
    }

    override fun onBindViewHolder(holder: tarifHolder, position: Int) {
holder.binding.textview.text=tarifListesi[position].isim
        holder.itemView.setOnClickListener{
            val action = ListeFragmentDirections.actionListeFragmentToTarifFragment("eski",tarifListesi[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }


}