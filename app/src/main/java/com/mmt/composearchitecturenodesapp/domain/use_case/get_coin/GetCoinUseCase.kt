package com.mmt.composearchitecturenodesapp.domain.use_case.get_coin

import com.mmt.composearchitecturenodesapp.common.Resource
import com.mmt.composearchitecturenodesapp.data.remote.dto.toCoinDetail
import com.mmt.composearchitecturenodesapp.domain.model.CoinDetail
import com.mmt.composearchitecturenodesapp.domain.repository.CoinRepositoryImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepositoryImpl
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin.toCoinDetail()))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could`t reach server. Check your internet connect"))
        }
    }
}