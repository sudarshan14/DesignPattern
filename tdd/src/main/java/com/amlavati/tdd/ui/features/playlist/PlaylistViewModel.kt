package com.amlavati.tdd.ui.features.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaylistViewModel : ViewModel() {

    val playList = MutableLiveData<List<PlayList>>()
}