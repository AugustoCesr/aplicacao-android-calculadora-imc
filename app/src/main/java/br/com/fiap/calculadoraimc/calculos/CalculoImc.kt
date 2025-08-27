package br.com.fiap.calculadoraimc.calculos

import androidx.compose.ui.graphics.Color
import kotlin.math.pow

fun calcularImc(pesoUsuario: Double, alturaUsuario: Double) : Double {
    var imc = pesoUsuario / (alturaUsuario / 100).pow(2)
    return imc
}

fun obterStatusImc(imcUsuario: Double) : String {
    return if (imcUsuario < 18.5) {
        "Abaixo do peso"
    } else if (imcUsuario >= 18.5 && imcUsuario < 25.0) {
        "Peso Ideal"
    } else if (imcUsuario >= 25.0 && imcUsuario < 30.0) {
        "Levemente\nacima do peso"
    } else if (imcUsuario >= 30.0 && imcUsuario < 35.0) {
        "Obesidade Grau I"
    } else if (imcUsuario >= 35.0 && imcUsuario < 40.0) {
        "Obesidade Grau II"
    } else {
        "Obesidade Grau III"
    }
}

fun corDoCardResultado(imc: Double): Color {
    return when {
        imc == 0.0 -> Color(0xFF329F6B)
        imc < 18.5 -> Color(0xFFB71C1C) // Abaixo do peso
        imc < 24.9 -> Color(0xFF329F6B) // Peso ideal
        imc < 29.9 -> Color(0xFFFF5722) // Levemente acima do peso
        imc < 34.9 -> Color(0xFFB71C1C) // Obesidade grau I
        imc < 39.9 -> Color(0xFFB71C1C) // Obesidade grau II
        else -> Color(0xFFB71C1C) // Obesidade grau III
    }
}
