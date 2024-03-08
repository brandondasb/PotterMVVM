package com.lambostudio.pottermvvm.ui

import androidx.lifecycle.ViewModel
import com.lambostudio.pottermvvm.data.Repo
import com.lambostudio.pottermvvm.data.NetworkSpell
import kotlinx.coroutines.flow.MutableStateFlow

class RandomSpellViewModel : ViewModel() {
    private val repo = Repo()
    private val _uiState = MutableStateFlow(NetworkSpell("-1", name = "", ""))
    val uiState = _uiState
    init {
        repo.getSpell()
    }

    fun generateSpell() {
        _uiState.value = if (repo.spells.value.isNotEmpty()){repo.spells.value.random()}else NetworkSpell("-1", name = "", "")
    }
}



