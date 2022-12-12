package com.mmt.composearchitecturenodesapp.presentation.coin_list

import com.mmt.composearchitecturenodesapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)