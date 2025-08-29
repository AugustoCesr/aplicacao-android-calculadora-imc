package br.com.fiap.calculadoraimc.calculos

import androidx.compose.ui.graphics.Color
import br.com.fiap.calculadoraimc.R
import kotlin.math.pow

fun calcularImc(pesoUsuario: Double, alturaUsuario: Double) : Double {
    var imc = pesoUsuario / (alturaUsuario / 100).pow(2)
    return imc
}

fun obterStatusImc(imcUsuario: Double): Int {
    return when {
        imcUsuario < 18.5 -> R.string.underweight_bmi
        imcUsuario < 25.0 -> R.string.bmi_ideal_weight
        imcUsuario < 30.0 -> R.string.slightly_overweight_bmi
        imcUsuario < 35.0 -> R.string.bmi_grade_I_obesity
        imcUsuario < 40.0 -> R.string.bmi_grade_II_obesity
        else -> R.string.bmi_grade_III_obesity
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
