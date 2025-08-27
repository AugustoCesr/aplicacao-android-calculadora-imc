package br.com.fiap.calculadoraimc.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import br.com.fiap.calculadoraimc.R

@Composable
fun CaixaDeEntrada(
    placeHolder: String,
    value: String,
    keyboardType: KeyboardType,
    modifier: Modifier,
    shape: Shape,
    atualizarValor: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = atualizarValor,
        modifier = modifier,
        placeholder = {
            Text(text = placeHolder)
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Gray,
            focusedBorderColor = colorResource(id = R.color.azul_padrao)
        ),
        shape = shape,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}