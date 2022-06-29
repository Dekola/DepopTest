package com.dekola.dekoladepoptest.characters.data.remoteDataSource

import com.dekola.dekoladepoptest.characters.data.CharacterApiService
import com.dekola.dekoladepoptest.characters.data.mapper.toPresentation
import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(private val apiService: CharacterApiService) :
    ICharacterRemoteDataSource {

    override suspend fun getAllCharacters():Result<List<CharacterPresentation>?> {
        return try {
            val response = apiService.getAllCharacters()
            if (response.isSuccessful){
                val characters = response.body()?.map { it.toPresentation() }
                Result.Success(characters)
            }else{
                Result.Error("An error occurred while fetching characters")
            }
        } catch (exception: Exception) {
            Result.Error("An error occurred while fetching characters")
        }
    }

}