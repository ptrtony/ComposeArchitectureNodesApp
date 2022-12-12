package com.mmt.composearchitecturenodesapp.data.remote

import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDetailDto
import com.mmt.composearchitecturenodesapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}