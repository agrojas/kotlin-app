package com.example.kotlinapp.repository

import com.example.kotlinapp.utils.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiService {

    const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"

    fun <S> create(clazz: Class<S>) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create(
            GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create()
        )).build()
        .create(clazz)
}