package com.inayatulmaula.applicationmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inayatulmaula.applicationmobile.databinding.ClubItemBinding
import com.inayatulmaula.applicationmobile.ui.navDrawer.FoodsFragment

class foodAdapter(private val list: List<Foods>, private val context: FoodsFragment) :
    RecyclerView.Adapter<foodAdapter.ViewHolder>() {

    class ViewHolder(val binding: ClubItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): foodAdapter.ViewHolder {
        val binding = ClubItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: foodAdapter.ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivMkn.setImageResource(this.image)
                binding.tvJdlMkn.text = this.name
                binding.tvDescMkn.text = this.desc
            }
        }
    }
}