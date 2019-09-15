package com.example.kotlinapp.presenter

import com.example.kotlinapp.model.User
import com.example.kotlinapp.view.View

interface UserDetailsPresenter<T : View>: Presenter<T> {
    var user: User?
}