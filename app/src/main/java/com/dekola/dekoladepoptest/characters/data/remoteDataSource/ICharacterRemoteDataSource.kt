package com.dekola.dekoladepoptest.characters.data.remoteDataSource

import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation

interface ICharacterRemoteDataSource {

    suspend fun getAllCharacters(): Result<List<CharacterPresentation>?>
}
