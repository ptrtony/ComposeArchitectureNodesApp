package com.mmt.composearchitecturenodesapp.presentation.coin_detail

import com.mmt.composearchitecturenodesapp.domain.model.CoinDetail

data class CoinDetailState(
    val coin: CoinDetail ?= null,
    val isLoading: Boolean = false,
    val error: String ? = ""
)