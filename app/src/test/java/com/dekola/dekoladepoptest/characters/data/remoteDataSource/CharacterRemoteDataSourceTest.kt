package com.dekola.dekoladepoptest.characters.data.remoteDataSource

import com.dekola.dekoladepoptest.characters.data.CharacterApiService
import com.dekola.dekoladepoptest.characters.data.model.CharacterDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.exceptions.base.MockitoException
import retrofit2.Response

@ExperimentalCoroutinesApi
class CharacterRemoteDataSourceTest {

    lateinit var remoteDataSource: CharacterRemoteDataSource

    @Mock
    lateinit var apiService: CharacterApiService

    lateinit var autoCloseable: AutoCloseable

    @Before
    fun setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this)
        remoteDataSource = CharacterRemoteDataSource(apiService)
    }

    @Test
    fun `test when getAllCharacters returns success`() = runTest {
        val successData = getCharacterSuccessData()
        Mockito.`when`(apiService.getAllCharacters()).thenReturn(Response.success(successData))

        val result = remoteDataSource.getAllCharacters()

        assert(result is Result.Success)
        Assert.assertEquals(TEST_CHARACTER_NAME,
            (result as Result.Success).data?.first()?.characterName)
    }

    @Test
    fun `test when getAllCharacters returns failure`() = runTest {
        Mockito.`when`(apiService.getAllCharacters())
            .thenReturn(Response.error(404, "".toResponseBody()))


        assert(remoteDataSource.getAllCharacters() is Result.Error)
    }

    @Test
    fun `test when getAllCharacters throws exception`() = runTest {
        Mockito.`when`(apiService.getAllCharacters())
            .thenThrow(MockitoException(""))


        assert(remoteDataSource.getAllCharacters() is Result.Error)
    }

    private fun getCharacterSuccessData(): List<CharacterDTO> {
        return listOf(CharacterDTO(name = TEST_CHARACTER_NAME))
    }

    companion object {
        const val TEST_CHARACTER_NAME = "testName"
    }

    @After
    fun tearDown() {
        autoCloseable.close()
    }
}