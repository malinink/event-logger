package com.github.malinink.eventlogger

import com.github.malinink.eventlogger.application.v1.v1
import com.github.malinink.eventlogger.infrastructure.template
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(Locations) {
    }

    install(DefaultHeaders) {
    }

    install(Koin) {
        slf4jLogger()
        modules(template)
    }

    install(ContentNegotiation) {
        gson {
            if (!testing) {
                setPrettyPrinting()
            }
        }
    }


    install(Routing) {
        // append routing from application here
        v1()
    }
}
