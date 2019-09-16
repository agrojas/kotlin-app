package com.example.kotlinapp.presenter

import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.view.View

interface PetDetailsPresenter<T : View>: Presenter<T> {
    var pet: Pet?
}