package com.dekola.dekoladepoptest.characters.data.model

data class CharacterResult(
    val data: List<CharacterPresentation>? = null,
    val errorMessage: String? = null,
    val loading: Boolean? = null,
)
