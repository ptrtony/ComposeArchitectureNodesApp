package com.mmt.composearchitecturenodesapp.domain.repository

import com.mmt.composearchitecturenodesapp.data.remote.CoinPaprikaApi
import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDetailDto
import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}