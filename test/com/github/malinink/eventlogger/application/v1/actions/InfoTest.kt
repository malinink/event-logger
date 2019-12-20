package com.github.malinink.eventlogger.application.v1.actions

import com.github.malinink.eventlogger.module
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class InfoTest {
    @Test
    fun testInfo() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/v1/info").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("{\"version\":\"0.0.1\"}", response.content)
            }
        }
    }
}
