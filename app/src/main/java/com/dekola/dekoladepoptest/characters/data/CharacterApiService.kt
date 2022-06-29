package com.dekola.dekoladepoptest.characters.data

import com.dekola.dekoladepoptest.characters.data.model.CharacterDTO
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("v2/characters")
    suspend fun getAllCharacters(): Response<List<CharacterDTO>>
}