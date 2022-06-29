package com.dekola.dekoladepoptest.characters.di

import com.dekola.dekoladepoptest.characters.data.CharacterApiService
import com.dekola.dekoladepoptest.characters.data.CharacterRepository
import com.dekola.dekoladepoptest.characters.data.ICharacterRepository
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.CharacterRemoteDataSource
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.ICharacterRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CharacterModule {

    @Provides
    fun provideCharacterRemoteDataSource(apiService: CharacterApiService): ICharacterRemoteDataSource =
        CharacterRemoteDataSource(apiService)

    @Provides
    fun provideCharacterRepository(remoteDataSource: ICharacterRemoteDataSource): ICharacterRepository =
        CharacterRepository(remoteDataSource)

}