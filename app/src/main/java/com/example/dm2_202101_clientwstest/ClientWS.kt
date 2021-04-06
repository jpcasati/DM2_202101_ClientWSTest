package com.example.dm2_202101_clientwstest

import android.os.StrictMode
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException


class ClientWS {

    @Throws(IOException::class, XmlPullParserException::class)
    fun receberOi(nome: String?): String? {

        val policy =
            StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)

        val soap = SoapObject(
            "http://servicos/",
            "dizeroi"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("nome", nome)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/dm2ws1/Saudacao?wsdl"
        )

        transmitir.call("dizeroi", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun receberTchau(nome: String?): String? {

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val soap = SoapObject("http://servicos/", "dizertchau")
        soap.addProperty("nome", nome)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        HttpTransportSE("http://10.0.2.2:8080/dm2ws1/Saudacao?wsdl").call("dizertchau", envelope)

        return envelope.response.toString()
    }

}