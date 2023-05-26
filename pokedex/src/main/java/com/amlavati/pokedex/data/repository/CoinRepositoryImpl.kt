package com.amlavati.pokedex.data.repository

import com.amlavati.pokedex.data.remote.CoinPaprikaApi
import com.amlavati.pokedex.data.remote.dto.CoinDetailDto
import com.amlavati.pokedex.data.remote.dto.CoinDto
import com.amlavati.pokedex.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}