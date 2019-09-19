package com.example.kotlinapp.view

import com.example.kotlinapp.model.Pet
import okhttp3.ResponseBody

interface View

interface PetsView : View {
    fun showPets(pets: List<Pet>)
    fun showPetsError(error: Throwable)
    fun showPetsError(error: ResponseBody?)
    fun showPetDetails(pet: Pet)
}

interface PetDetailsView : View {
    fun showPetDetails(pet: Pet)
    fun showNoPetError()
}
