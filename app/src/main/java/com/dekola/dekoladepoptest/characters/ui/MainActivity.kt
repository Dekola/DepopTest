package com.dekola.dekoladepoptest.characters.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dekola.dekoladepoptest.characters.di.CharacterViewModel
import com.dekola.dekoladepoptest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    private val characterNameAdapter: CharacterNameAdapter by lazy { CharacterNameAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()
        setObservers()
    }

    private fun setObservers() {
        with(viewModel) {
            characterResult.observe(this@MainActivity) { characterResult ->
                if (characterResult.data != null) {
                    characterNameAdapter.submitList(characterResult.data)
                }
                if (characterResult.errorMessage != null) {
                    showSnackBar(characterResult.errorMessage)
                }
                if (characterResult.loading != null) {
                    binding.characterNameSrl.isRefreshing = characterResult.loading
                }
            }
        }
    }

    private fun showSnackBar(errorMessage: String) {
        Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_SHORT).show()
    }

    private fun setViews() {
        with(binding) {
            characterNameRv.adapter = characterNameAdapter
            characterNameSrl.setOnRefreshListener {
                getAllCharacters()
            }
        }
    }

    private fun getAllCharacters() {
        viewModel.getAllCharacters()
    }
}