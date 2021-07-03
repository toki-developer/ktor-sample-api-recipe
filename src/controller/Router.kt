package com.example.controller

import com.example.framework.Database
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.apiRouter() {
    val database = Database()
    route("/api"){
        get(""){
            call.respond(mapOf("message" to "API endpoint"))
        }
        recipe(database.recipeDao)
    }
}