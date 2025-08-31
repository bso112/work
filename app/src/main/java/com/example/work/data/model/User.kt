package com.example.work.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("username")
    val username: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("website")
    val website: String
)