package com.amlavati.pokedex.domain.usecase.getcoin

import com.amlavati.pokedex.common.Resource
import com.amlavati.pokedex.data.remote.dto.CoinDetailDto
import com.amlavati.pokedex.data.remote.dto.CoinDto
import com.amlavati.pokedex.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetailDto>> = flow {
        try {

            emit(Resource.Loading())
            val coinDetail = coinRepository.getCoinById(coinId)
            emit(Resource.Success(coinDetail))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Couldn't reach internet. "))
        }
    }
}