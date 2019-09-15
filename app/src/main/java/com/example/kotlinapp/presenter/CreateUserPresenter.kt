package com.example.kotlinapp.presenter

import com.example.kotlinapp.view.View

interface CreateUserPresenter<T: View>: Presenter<T> {
    fun saveUser(name:String, surname: String)
}