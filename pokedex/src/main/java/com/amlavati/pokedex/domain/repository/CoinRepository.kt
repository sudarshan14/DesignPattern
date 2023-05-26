package com.amlavati.pokedex.domain.repository

import com.amlavati.pokedex.data.remote.dto.CoinDetailDto
import com.amlavati.pokedex.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}