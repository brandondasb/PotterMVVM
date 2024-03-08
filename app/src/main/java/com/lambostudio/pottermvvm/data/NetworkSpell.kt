package com.lambostudio.pottermvvm.data

import kotlinx.serialization.Serializable

@Serializable
data class NetworkSpell(
    val id: String,
    val name: String,
    val description: String
)
