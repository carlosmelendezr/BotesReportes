package com.carleodev.botesrep.Util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(date)
}

fun convertDateToInt(date:Date): Int {
    val format = SimpleDateFormat("yyyyMMdd")
    return format.format(date).toInt()
}

fun convertHourToInt(date:Date): Int {
    val format = SimpleDateFormat("HHmm")
    return format.format(date).toInt()
}

fun convertDateToHora(date:Date): String {
    val format = SimpleDateFormat("HH:mm")
    return format.format(date)
}

fun esValorValido(valor:String):Boolean {
    var esvalido = false
    var valordoble = 0.0
    try {
        valordoble = valor.toDouble()
        if (valordoble > 1) esvalido = true
    } catch (e:Exception) {
        Log.e("INT","Valor no valid0 ")
    }
    return esvalido

}

fun esEnteroValido(valor:String):Boolean {
    var esvalido = false
    var valorent = 0
    try {
        valorent = valor.toInt()
        if (valorent > 0) esvalido = true
    } catch (e:Exception) {
        Log.e("INT","Valor no valid0 ")
    }
    return esvalido
}

fun convertLongToTimeScreen(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("dd-MM-yyyy")
    return format.format(date)
}

fun convertIntToTimeScreen(time: Int): String {
    val hora = time.toString()
    return hora.substring(hora.length-2,8)+"/"+hora.substring(hora.length-4,6)+"/"+hora.substring(0,4)
}

fun mostrarHora(Hora:Int):String {
    val sHora = Hora.toString()
    val min = sHora.substring(2,4)
    var ampm = "AM"
    var hor = sHora.substring(0,2).toInt()
    if (hor>12) {
        hor -= 12
        ampm = "PM"
        return "0$hor:$min $ampm"
    }
    return "$hor:$min $ampm"
}