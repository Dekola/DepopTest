package com.dekola.dekoladepoptest.characters.di

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dekola.dekoladepoptest.characters.data.CharacterRepository
import com.dekola.dekoladepoptest.characters.data.model.CharacterPresentation
import com.dekola.dekoladepoptest.characters.data.remoteDataSource.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class CharacterViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    var test = UnconfinedTestDispatcher()

    @Mock
    lateinit var repository: CharacterRepository

    lateinit var viewModel: CharacterViewModel

    lateinit var autoCloseable: AutoCloseable

    @Before
    fun setUp() {
        Dispatchers.setMain(test)

        autoCloseable = MockitoAnnotations.openMocks(this)
        viewModel = CharacterViewModel(repository)
    }

    @Test
    fun `when getAllCharacters returns Success`() = runTest {
        val successData = getCharacterSuccessData()
        Mockito.`when`(repository.getAllCharacters()).thenReturn(Result.Success(successData))

        val characterName = viewModel.characterResult.value?.data?.first()?.characterName
        Assert.assertEquals(TEST_CHARACTER_NAME, characterName)
    }

    @After
    fun tearDown() {
        test.cancel()
        autoCloseable.close()
    }


    private fun getCharacterSuccessData(): List<CharacterPresentation> {
        return listOf(CharacterPresentation(characterName = TEST_CHARACTER_NAME))
    }


    companion object {
        const val TEST_CHARACTER_NAME = "testName"
    }

}