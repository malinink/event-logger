package com.github.malinink.eventlogger.application.v1.actions

import com.github.malinink.eventlogger.application.v1.models.Info
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1Info() {
    respond(Info("0.0.1"))
}
