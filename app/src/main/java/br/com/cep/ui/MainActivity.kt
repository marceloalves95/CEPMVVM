package br.com.cep.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.cep.core.extensions.toast
import br.com.cep.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel:MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

    }

    private fun initViews(){

        binding.run {

            progressBar.visibility = View.INVISIBLE

            with(buscar){
                setOnClickListener {
                    val cep = cep.editableText.toString()
                    viewModel.getBusca(cep)
                    initViewModel()
                }
            }
        }
    }
    private fun initViewModel(){
        lifecycleScope.launchWhenStarted {
            viewModel.state.observe(this@MainActivity,{ state->
                with(state){
                    when(this){
                        is MainActivityViewModel.State.Error -> {
                            toast(message, Toast.LENGTH_SHORT)
                        }
                        is MainActivityViewModel.State.Loading -> {
                            with(binding){
                                if (isLoading)
                                    progressBar.visibility = View.VISIBLE
                                else
                                    progressBar.visibility = View.INVISIBLE
                            }
                        }
                        is MainActivityViewModel.State.Sucess -> {

                            response?.let { cep->
                                with(binding){
                                    group.visibility = View.VISIBLE
                                    address.text = cep.address
                                    district.text = cep.district
                                    city.text = cep.city
                                    this.state.text = cep.state
                                }
                            }

                        }
                    }
                }

            })
        }
    }
}