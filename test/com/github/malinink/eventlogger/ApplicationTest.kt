package com.github.malinink.eventlogger

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlin.test.assertEquals

class ApplicationTest {

    // TODO example of complex test with client mock
    suspend fun testClientMock() {
        val client = HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.encodedPath) {
                        "/" -> respond(
                            ByteReadChannel(byteArrayOf(1, 2, 3)),
                            HttpStatusCode.OK,
                            headersOf("X-MyHeader", "MyValue")
                        )
                        else -> respondError(HttpStatusCode.NotFound, "Not Found ${request.url.encodedPath}")
                    }
                }
            }
        }

        assertEquals(byteArrayOf(1, 2, 3).toList(), client.get<ByteArray>("/").toList())
        //assertEquals("MyValue", client.request() call("/").response.headers["X-MyHeader"])
        assertEquals("Not Found other/path", client.get<String>("/other/path"))
    }
}
