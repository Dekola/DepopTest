package com.dekola.dekoladepoptest.characters.data.mapper

import com.dekola.dekoladepoptest.characters.data.model.CharacterDTO
import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation

fun CharacterDTO.toPresentation() = CharacterPresentation(characterName =  name)