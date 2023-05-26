package com.amlavati.pokedex.domain.usecase.getcoins

import com.amlavati.pokedex.common.Resource
import com.amlavati.pokedex.data.remote.dto.CoinDto
import com.amlavati.pokedex.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<CoinDto>>> = flow {
        try {

            emit(Resource.Loading())
            val coins = coinRepository.getCoins()
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
             emit(Resource.Error(e.localizedMessage?:"Couldn't reach internet. "))
        }
    }
}