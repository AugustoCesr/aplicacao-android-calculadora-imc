package br.com.fiap.calculadoraimc.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculadoraimc.R
import br.com.fiap.calculadoraimc.calculos.corDoCardResultado
import br.com.fiap.calculadoraimc.components.CaixaDeEntrada
import br.com.fiap.calculadoraimc.components.CardResultado

@Composable
fun IMCScreen(imcScreenViewModel: ImcScreenViewModel) {
    val peso by imcScreenViewModel.peso.observeAsState("")
    val altura by imcScreenViewModel.altura.observeAsState("")
    val imc by imcScreenViewModel.imc.observeAsState(0.0)
    val statusImc by imcScreenViewModel.statusImc.observeAsState("")

    Box(
        modifier = Modifier.fillMaxSize().padding(top = 22.dp)
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
        ) {
            // ---- header
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(colorResource(id = R.color.azul_padrao))
            ) {
                Spacer(modifier = Modifier.height(34.dp))
                Image(
                    painter = painterResource(id = R.drawable.imc),
                    contentDescription = "Imagem escrito I M C",
                    modifier =
                        Modifier
                            .size(60.dp)
                            .clip(shape = CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "CALCULADORA IMC",
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.white)
                )
            }
            // ---- formulário
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(32.dp)
            ) {
                Card(
                    modifier =
                        Modifier
                            .offset(y = (-60).dp)
                            .fillMaxWidth(),
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier =
                        Modifier
                            .padding(vertical = 16.dp, horizontal = 32.dp)
                    ) {
                        Text(
                            text = "Seus dados",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.azul_padrao),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(
                            text = "Seu peso",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.azul_padrao)
                        )
                        CaixaDeEntrada(
                            value = peso,
                            placeHolder = "Seu peso em Kg",
                            keyboardType = KeyboardType.Number,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            atualizarValor = {
                                imcScreenViewModel.onPesoChange(it)
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sua altura",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(id = R.color.azul_padrao)
                        )
                        CaixaDeEntrada(
                            value = altura,
                            placeHolder = "Sua altura em cm.",
                            keyboardType = KeyboardType.Number,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            atualizarValor = {
                                imcScreenViewModel.onAlturaChange(it)
                            }
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                imcScreenViewModel.calcularImcViewModel()
                                imcScreenViewModel.obterStatusImcViewModel()
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.azul_padrao))
                        ) {
                            Text(
                                text = "CALCULAR",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                    OutlinedButton(
                        onClick = {
                            imcScreenViewModel.limparResultados()
                        },
                        modifier = Modifier
                            .width(200.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFF14769F))
                    ) {
                        Text(
                            text = "Limpar resultado",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color(0xFF14769F)
                        )
                    }
                }
            }
        }
        // ---- Card resultado
        CardResultado(statusImc = statusImc, imc = imc)

    }
}