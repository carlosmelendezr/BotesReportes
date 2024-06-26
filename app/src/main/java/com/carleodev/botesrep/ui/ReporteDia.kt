package com.carleodev.botesrep.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Airlines
import androidx.compose.material3.AlertDialogDefaults.shape

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color


import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.carleodev.botesrep.AppViewModelProvider
import com.carleodev.botesrep.Util.convertDateToInt
import com.carleodev.botesrep.Util.convertIntToTimeScreen
import com.carleodev.botesrep.data.ResumenVenta
import com.carleodev.botesrep.navigation.NavigationDestination
import com.carleodev.botesrep.ui.theme.BotesRepTopAppBar
import java.util.Date


object ReporteDiaDestination : NavigationDestination {
    override val route = "reportedia"
    override val titleRes = 4
}


@Composable
fun ReporteDiaScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    navigateToDetalles:()->Unit,
    viewModel:ReporteDiaViewModel = viewModel(factory = AppViewModelProvider.Factory))
{
    val listaresumenVenta = viewModel.listaResumenVenta.collectAsState(emptyList())

    Scaffold(
        topBar = {
            BotesRepTopAppBar(
                title = "Reporte del dia " ,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToDetalles() },
                modifier = Modifier.navigationBarsPadding()
            )
            {
                Icon(
                    imageVector = Icons.Default.Airlines,
                    contentDescription = "Detalles",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        },
    ) { innerPadding ->
        LazyColumn {
            items(listaresumenVenta.value) {
                item: ResumenVenta ->  MostarPagos(item,
                modifier = modifier.padding(innerPadding))
            }
        }


    }
}




@Composable
fun MostarPagos(resumenVenta: ResumenVenta,
                modifier: Modifier = Modifier)
{
    val fecha = fechadia(resumenVenta.id.toInt())
    var colorFondo = Color.White
    when(fecha) {
        "HOY"  -> colorFondo = Color.Cyan
        "Ayer" -> colorFondo = Color.LightGray
    }

    Card() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 30.dp))
            .clip(CutCornerShape(bottomEnd = 30.dp))
            .background(colorFondo)
            .border(3.dp, Color.Black, shape)
            .padding(16.dp)
        ) {
        Column( )
        {

            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "AZULES : ${resumenVenta.boteAzules}",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.background(Color.Blue)
                )

                Text(
                    text = "AMARILLOS : ${resumenVenta.boteAmarillo}",
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.background(Color.Yellow)
                )
                Text(
                    text = "ANULADOS : ${resumenVenta.anulados}",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.background(Color.Red)

                )
            }

                Column() {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "EFECTIVO BS: ${resumenVenta.pagosEfectivoBs}",
                            style = MaterialTheme.typography.h6,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,

                            )
                        Text(
                            text = "EFECTIVO $: ${resumenVenta.pagosDivisa}",
                            style = MaterialTheme.typography.h6,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,

                            )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Bancamiga: ${resumenVenta.pagosBancaAmiga}",
                            style = MaterialTheme.typography.h6,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,

                            )
                        Text(
                            text = "Pago Movil: ${resumenVenta.pagosMovil}",
                            style = MaterialTheme.typography.h6,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,

                            )
                        Text(
                            text = "Venezuela : ${resumenVenta.pagosVenezuela}",
                            style = MaterialTheme.typography.h6,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Left,

                            )
                    }
                }
            Divider(color = Color.Black, thickness = 1.dp)
            Text(
                text = fecha,
                style = MaterialTheme.typography.h5,
                fontSize = 14.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )

            }


        }



    }
}

fun fechadia(Fecha:Int):String {
    val hoy = convertDateToInt(Date())
    val diff=hoy-Fecha
    var mess = ""
    when(diff) {
        0 -> mess="HOY"
        1 -> mess="Ayer"
        else -> mess = convertIntToTimeScreen(Fecha)
    }
    return mess
}




@Composable
@Preview
fun  MostarPagosPreview(){
    MostarPagos(ResumenVenta(id="1b", boteAzules = 10,
        boteAmarillo = 20, anulados = 2,
        pagosDivisa = 100.0, pagosVenezuela = 2500.0,
        pagosBancaAmiga = 1500.0, pagosEfectivoBs = 850.0, pagosMovil = 900.0))

}