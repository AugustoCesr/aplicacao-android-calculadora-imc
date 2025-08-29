package br.com.fiap.calculadoraimc.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculadoraimc.R
import br.com.fiap.calculadoraimc.calculos.corDoCardResultado

@Composable
fun BoxScope.CardResultado(statusImc: Int, imc: Double) {
    Card(modifier =
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 32.dp, vertical = 24.dp)
            .align(Alignment.BottomCenter),
        colors = CardDefaults.cardColors(containerColor = corDoCardResultado(imc)),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxSize()
        ) {
            Column() {
                Text(
                    text = stringResource(id = R.string.result_card_text),
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(id = statusImc!!),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 22.sp
                )
            }
            Text(
                text = String.format("%.1f", imc),
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 38.sp,
                textAlign = TextAlign.End
            )
        }
    }
}
