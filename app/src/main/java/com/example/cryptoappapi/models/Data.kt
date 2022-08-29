package com.example.cryptoappapi.models

data class Data(
    val cryptoCurrencyList: List<CryptoCurrency>,
    val totalCount: String?
)