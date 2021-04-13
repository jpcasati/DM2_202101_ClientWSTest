package com.example.dm2_202101_clientwstest

import org.ksoap2.serialization.KvmSerializable
import org.ksoap2.serialization.PropertyInfo
import java.util.*

data class Carro (val placa: String, val modelo: String, val ano: Int) : KvmSerializable {

    override fun getProperty(index: Int): Any {

        if(index == 0)
            return placa
        else if(index == 1)
            return modelo
        else if(index == 2)
            return ano
        return "null"
    }

    override fun getPropertyCount(): Int {
        return 3
    }

    override fun getPropertyInfo(index: Int, properties: Hashtable<*, *>?, info: PropertyInfo?) {

        if (info == null)
            return

        when (index) {
            0 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "placa"
            }
            1 -> {
                info.type = PropertyInfo.STRING_CLASS
                info.name = "modelo"
            }
            2 -> {
                info.type = PropertyInfo.INTEGER_CLASS
                info.name = "ano"
            }
            else -> {}
        }
    }

    override fun setProperty(index: Int, value: Any?) {
        when (index) {
            0 -> value.toString()
            1 -> value.toString()
            2 -> value
            else -> "null"
        }
    }

    override fun toString(): String {
        return "Carro[placa = " + placa + ", modelo = " + modelo + ", ano = " + ano + "]"
    }
}