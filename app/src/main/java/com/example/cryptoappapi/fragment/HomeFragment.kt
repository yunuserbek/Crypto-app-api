package com.example.cryptoappapi.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.cryptoappapi.R
import com.example.cryptoappapi.adapter.TopMarketAdapter
import com.example.cryptoappapi.api.ApiInterface
import com.example.cryptoappapi.api.ApiUtilities
import com.example.cryptoappapi.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher


class HomeFragment : Fragment() {

private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        getTopCurrencyList()
        return binding.root
    }

    private fun getTopCurrencyList() {
        lifecycleScope.launch(Dispatchers.IO){
            val res =ApiUtilities.getInstance().create(ApiInterface::class.java).getMarketData()
            withContext(Dispatchers.Main){
                binding.topCurrencyRecyclerView.adapter = TopMarketAdapter(requireContext(), res.body()!!.data!!.cryptoCurrencyList)
            }
            Log.d("TAG","getTopCurrrenmcyList:${res.body()!!.data?.cryptoCurrencyList}")
        }
    }


}