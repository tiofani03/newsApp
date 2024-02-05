package com.tiooooo.newsapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val name: String,
)

val dummyCategory = listOf(
    Category(1, "Olahraga"),
    Category(1, "Kesenian"),
    Category(1, "Keuangan"),
    Category(1, "Tech"),
    Category(1, "Politik"),
)


