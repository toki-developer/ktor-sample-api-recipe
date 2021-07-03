package com.example.controller

import com.example.dao.RecipeDao
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.recipe(recipeDao: RecipeDao) {
    route("/recipes"){
        get(""){
            val recipe = recipeDao.selectAll()
            call.respond(recipe)
        }
        get("/{id}") {
            val id = call.parameters["id"]!!
            val recipe = recipeDao.selectById(Integer.parseInt(id))
            if( recipe == null) {
                throw (NotFoundException("not found recipe with id: ${id}"))
            } else {
                call.respond(HttpStatusCode.OK, recipe)
            }
        }
    }
}