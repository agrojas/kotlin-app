package com.example.kotlinapp.repository

import com.example.kotlinapp.model.Pet
import retrofit2.Call

class PetsApiData : DataSource<Pet> {

    private val api: SwaggerPetsApi = ApiService.create(SwaggerPetsApi::class.java)

    override fun getAll(): Call<List<Pet>> {
        return api.getPetList()
    }


}
