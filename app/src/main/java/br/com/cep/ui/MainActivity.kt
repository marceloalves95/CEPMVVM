package br.com.cep.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cep.R
import br.com.cep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}