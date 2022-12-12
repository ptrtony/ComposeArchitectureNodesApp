package com.mmt.composearchitecturenodesapp.domain.repository

import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDetailDto
import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}