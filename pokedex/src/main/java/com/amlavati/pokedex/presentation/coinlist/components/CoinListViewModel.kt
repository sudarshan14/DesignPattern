package com.amlavati.pokedex.presentation.coinlist.components

import androidx.lifecycle.ViewModel
import com.amlavati.pokedex.domain.usecase.getcoins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(getCoinsUseCase: GetCoinsUseCase) : ViewModel() {

}