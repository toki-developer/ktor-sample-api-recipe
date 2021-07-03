package com.example.model

import org.jdbi.v3.core.mapper.reflect.ColumnName

data class Recipes(
    val id: Int,
    val name: String,
    val cost: Int,
    val ingredients: String,
    @ColumnName("created_at")
    val createdAt: String,
    @ColumnName("updated_at")
    val updatedAt: String
)