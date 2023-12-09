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
import com.inayatulmaula.applicationmobile.databinding.FragmentFoodsBinding
import com.inayatulmaula.applicationmobile.foodAdapter

class FoodsFragment : Fragment() {

    private lateinit var binding: FragmentFoodsBinding
    private lateinit var adapter: foodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodsBinding.inflate(inflater, container, false)
        val view = binding.root

        init()
        setRvAdapter()
//
        return view

    }

    private fun init() {
        binding.listFoodRv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setRvAdapter() {
        val dataList: MutableList<Foods> = mutableListOf()

        namefoods().forEachIndexed { index, name ->
            dataList.add(Foods(imagefoods().get(index), name, descfoods()[index]))
        }
        Log.d("ISI DATANYA ", dataList.toString())
        adapter = foodAdapter(dataList, this@FoodsFragment)
        binding.listFoodRv.adapter = adapter
    }

    private fun namefoods(): Array<String> = resources.getStringArray(R.array.data_nama)
    private fun descfoods(): Array<String> = resources.getStringArray(R.array.data_description)

    private fun imagefoods(): List<Int> = listOf(
        R.drawable.nasi_goreng,
        R.drawable.nasi_kuning,
        R.drawable.nasi_padang,
        R.drawable.sate,
        R.drawable.soto,
        R.drawable.bakso
    )

}