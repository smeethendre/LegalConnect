package com.example.legalapp.Model

data class Lawyer(
    val name: String = "",
    val specialty: String = "",
    val rating: Float = 0f,
    val experience: Int = 0,
    val profileImageUrl: String = ""
) {

    constructor() : this("", "", 0f, 0, "")
}
