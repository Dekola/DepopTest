package com.dekola.dekoladepoptest.characters.di

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dekola.dekoladepoptest.characters.data.ICharacterRepository
import com.dekola.dekoladepoptest.characters.data.model.CharacterResult
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: ICharacterRepository) :
    ViewModel() {

    private val _characterResult = MutableLiveData<CharacterResult>()
    val characterResult: LiveData<CharacterResult> = _characterResult

    fun getAllCharacters() {
        viewModelScope.launch {
//            _characterResult.postValue(CharacterResult(loading = true))
            when (val result = repository.getAllCharacters()) {
                is Result.Error -> {
                    _characterResult.postValue(CharacterResult(errorMessage = result.errorMessage))
                }
                is Result.Success -> {
                    _characterResult.postValue(CharacterResult(data = result.data))
                }
            }
            _characterResult.postValue(CharacterResult(loading = false))
        }
    }

    init {
        getAllCharacters()
    }

}