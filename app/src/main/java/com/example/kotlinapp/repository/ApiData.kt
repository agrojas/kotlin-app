package com.example.kotlinapp.repository

import com.example.kotlinapp.model.Pet
import kotlin.reflect.KClass

object ApiData {

    fun <Entity : Any> of(clazz: KClass<*>): DataSource<Entity> {
        return when (clazz) {
            Pet::class -> PetsApiData()
            else -> throw IllegalArgumentException("Unsupported data type")
        } as DataSource<Entity>
    }
}