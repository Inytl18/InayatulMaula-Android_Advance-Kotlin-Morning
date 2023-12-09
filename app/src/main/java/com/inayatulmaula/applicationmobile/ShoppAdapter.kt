package com.inayatulmaula.applicationmobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inayatulmaula.applicationmobile.databinding.ClubItemBinding
import com.inayatulmaula.applicationmobile.databinding.ShopItemBinding
import com.inayatulmaula.applicationmobile.ui.navDrawer.FoodsFragment
import com.inayatulmaula.applicationmobile.ui.navDrawer.ShopFragment

class ShoppAdapter(private val list: List<Foods>, private val context: ShopFragment) :
    RecyclerView.Adapter<ShoppAdapter.ViewHolder>() {

    class ViewHolder(val binding: ShopItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppAdapter.ViewHolder {
        val binding = ShopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivShop.setImageResource(this.image)
                binding.tvJdlShop.text = this.name
                binding.tvDescShop.text = this.desc
            }
        }
    }
}