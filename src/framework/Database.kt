package com.example.framework

import com.example.dao.RecipeDao
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.jdbi.v3.sqlobject.kotlin.KotlinSqlObjectPlugin

class Database {
    val recipeDao: RecipeDao
    init {
        val jdbi = Jdbi.create("jdbc:postgresql://localhost:5434/recipe","recipe","recipe")
            .installPlugin(SqlObjectPlugin())
            .installPlugin(KotlinPlugin())
            .installPlugin(KotlinSqlObjectPlugin())

        recipeDao = jdbi.onDemand(RecipeDao::class.java)
    }
}