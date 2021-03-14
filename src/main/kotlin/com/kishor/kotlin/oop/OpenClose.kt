package com.kishor.kotlin.oop

import jdk.incubator.http.HttpClient
import jdk.incubator.http.HttpRequest
import jdk.incubator.http.HttpResponse
import java.net.URI

//class Network {
//    private val url = URI("http://1234")
//
//    fun broadcast(message: String) {
//        val httpClient = HttpClient.newHttpClient()
//        val body = HttpRequest.BodyPublisher.fromString(message)
//        val request = HttpRequest.newBuilder(url).POST(body).build()
//        httpClient.send(request, HttpResponse.BodyHandler.asInputStream())
//    }
//}


// chages to

interface Network {
    fun broadCast(message: String)
}

class HttpNetwork : Network {
    private val url = URI("http://1234")
    override fun broadCast(message: String) {
        val httpClient = HttpClient.newHttpClient()
        val body = HttpRequest.BodyPublisher.fromString(message)
        val request = HttpRequest.newBuilder(url).POST(body).build()
        httpClient.send(request, HttpResponse.BodyHandler.asInputStream())
    }
}

class WebSocketNetwork : Network {
    override fun broadCast(message: String) {
        TODO("Not yet implemented")
    }
}
