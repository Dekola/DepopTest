package com.dekola.dekoladepoptest.characters.data

import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.Result

interface ICharacterRepository {
    suspend fun getAllCharacters(): Result<List<CharacterPresentation>?>

}
