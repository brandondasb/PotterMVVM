package com.lambostudio.pottermvvm.data

class FakeLocalData {
    fun allSpells(): List<NetworkSpell> =
        listOf(
            NetworkSpell("1", "some Harry spell 1", "the spell description 1"),
            NetworkSpell("2", "some Harry spell 2", "the spell description 2"),
            NetworkSpell("3", "some Harry spell 3", "the spell description 3"),
            NetworkSpell("4", "some Harry spell 4", "the spell description 4"),
            NetworkSpell("5", "some Harry spell 5", "the spell description 5"),
        )
}
