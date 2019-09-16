package com.example.kotlinapp.presenter

import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.view.View

interface PetPresenter<T: View>: Presenter<T> {
    fun findPets()
    fun showPetDetails(pet: Pet)
}