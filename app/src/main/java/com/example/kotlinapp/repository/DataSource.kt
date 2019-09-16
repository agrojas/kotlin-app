package com.example.kotlinapp.repository

import retrofit2.Call

interface DataSource<T : Any> {

    fun getAll(): Call<List<T>>

}
