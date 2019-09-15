package com.example.kotlinapp.presenter

import com.example.kotlinapp.view.View

interface Presenter<T: View> {

    var view: T?

    fun onDestroy() {
        view = null;
    }
}