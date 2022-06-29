package com.dekola.dekoladepoptest.characters.data

import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.ICharacterRemoteDataSource
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.Result
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val remoteDataSource: ICharacterRemoteDataSource) :
    ICharacterRepository {

    override suspend fun getAllCharacters(): Result<List<CharacterPresentation>?> {
        return remoteDataSource.getAllCharacters()
    }
}