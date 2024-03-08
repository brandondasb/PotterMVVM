package com.lambostudio.pottermvvm.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class Repo {
    private val scope = CoroutineScope(context = SupervisorJob())

    private val localData = FakeLocalData()
    private val onlineData = OnlineData()
    private val _spells: MutableStateFlow<List<NetworkSpell>> = MutableStateFlow(
        emptyList()
    )
    val spells: StateFlow<List<NetworkSpell>> = _spells

    //    fun getSpell() = localData.allSpells()
    fun getSpell() {
        scope.launch {
            _spells.value = onlineData.getSpellsList()
        }

    }
}

