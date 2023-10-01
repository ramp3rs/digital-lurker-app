package io.digitallurker.models

import java.io.File

data class Attraction(
    val name: String,
    val image: File,
    val location: String,
    val description: String,
    val isActive: Boolean,
    val experience: Int,
)