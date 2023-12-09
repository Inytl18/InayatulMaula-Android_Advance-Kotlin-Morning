package com.inayatulmaula.applicationmobile.ui.navDrawer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inayatulmaula.applicationmobile.Foods
import com.inayatulmaula.applicationmobile.R
import com.inayatulmaula.applicationmobile.ShoppAdapter
import com.inayatulmaula.applicationmobile.databinding.FragmentFoodsBinding
import com.inayatulmaula.applicationmobile.databinding.FragmentShopBinding
import com.inayatulmaula.applicationmobile.foodAdapter

class ShopFragment : Fragment() {

    private lateinit var binding: FragmentShopBinding
    private lateinit var adapter: ShoppAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        val view = binding.root

        init()
        setRvAdapter()
//
        return view

    }

    private fun init() {
        binding.rvShop.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setRvAdapter() {
        val dataList: MutableList<Foods> = mutableListOf()

        nameshop().forEachIndexed { index, name ->
            dataList.add(Foods(imageshop().get(index), name, descshop()[index]))
        }
        Log.d("ISI DATANYA ", dataList.toString())
        adapter = ShoppAdapter(dataList, this@ShopFragment)
        binding.rvShop.adapter = adapter
    }

    private fun nameshop(): Array<String> = resources.getStringArray(R.array.dataNamaShop)
    private fun descshop(): Array<String> = resources.getStringArray(R.array.dataDescShop)

    private fun imageshop(): List<Int> = listOf(
        R.drawable.baju1,
        R.drawable.baju2,
        R.drawable.all_skincare,
        R.drawable.moist,
        R.drawable.sunscreen,
        R.drawable.celana,
        R.drawable.hoodie
    )

}