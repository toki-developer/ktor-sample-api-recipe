package com.example.dao

import com.example.model.Recipes
import org.jdbi.v3.sqlobject.SingleValue
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.SqlQuery

interface RecipeDao {
    @SqlQuery("SELECT * FROM recipes")
    fun selectAll(): List<Recipes>

    @SqlQuery("SELECT * FROM recipes where id = :id")
    @SingleValue
    fun selectById(id: Int): Recipes?
}