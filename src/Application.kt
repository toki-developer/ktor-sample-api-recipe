package com.example

import com.example.controller.apiRouter
import com.example.dao.RecipeDao
import com.example.model.Recipes
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.features.*
import com.fasterxml.jackson.databind.*
import io.ktor.http.*
import io.ktor.jackson.*
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.statement.SqlQuery

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)



@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    routing {
        apiRouter()
        install(StatusPages) {
            data class ErrorResponse(val message: String?)
//            exception<AuthenticationException> { cause ->
//                call.respond(HttpStatusCode.Unauthorized)
//            }
//            exception<AuthorizationException> { cause ->
//                call.respond(HttpStatusCode.Forbidden)
//            }
            exception<NotFoundException> {
                println("======ここ")
                call.respond(HttpStatusCode.NotFound, ErrorResponse(it.message))
            }
        }
    }


}

//class AuthenticationException : RuntimeException()
//class AuthorizationException : RuntimeException()

