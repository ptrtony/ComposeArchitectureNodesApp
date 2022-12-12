package com.mmt.composearchitecturenodesapp.domain.use_case.get_coins

import com.mmt.composearchitecturenodesapp.common.Resource
import com.mmt.composearchitecturenodesapp.data.remote.dto.toCoin
import com.mmt.composearchitecturenodesapp.domain.model.Coin
import com.mmt.composearchitecturenodesapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map {
                it.toCoin()
            }
            emit(Resource.Success(data = coins))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Could`t reach server. Check your internet connect"))
        }
    }
}