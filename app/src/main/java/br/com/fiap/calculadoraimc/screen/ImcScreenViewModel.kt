package br.com.fiap.calculadoraimc.screen

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.calculadoraimc.R
import br.com.fiap.calculadoraimc.calculos.calcularImc
import br.com.fiap.calculadoraimc.calculos.obterStatusImc

class ImcScreenViewModel : ViewModel() {
    private val _peso = MutableLiveData<String>()
    val peso: LiveData<String> = _peso
    private val _altura = MutableLiveData<String>()
    val altura: LiveData<String> = _altura
    private val _imc = MutableLiveData<Double>()
    val imc: LiveData<Double> = _imc
    private val _statusImc = MutableLiveData<Int>()
    val statusImc: LiveData<Int> = _statusImc

    fun onPesoChange(novoPeso: String) {
        _peso.value = novoPeso
    }

    fun onAlturaChange(novaAltura: String) {
        _altura.value = novaAltura
    }

    fun calcularImcViewModel() {
        _imc.value = calcularImc(
            pesoUsuario = _peso.value!!.toDouble(),
            alturaUsuario = _altura.value!!.toDouble()
        )
    }

    fun obterStatusImcViewModel() {
        _statusImc.value = obterStatusImc(imcUsuario = _imc.value!!)
    }

    fun limparResultados() {
        _imc.value = 0.0
        _statusImc.value = R.string.empty_string
    }
}