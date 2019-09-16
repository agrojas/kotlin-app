package com.example.kotlinapp.repository

import com.example.kotlinapp.model.Pet
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface SwaggerPetsApi {
    @GET("pets")
    fun getPetList(): Call<List<Pet>>

    @GET("pets/{id}")
    fun getPet(@Path("id") id: Int): Call<Pet>

    @DELETE("pets/{id}")
    fun deletePet(@Path("id") id: Int)

}