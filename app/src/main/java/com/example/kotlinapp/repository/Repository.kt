package com.example.kotlinapp.repository

import com.example.kotlinapp.model.Pet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

object Repository {

    inline fun <reified Entity : Any> of(): Repo<Entity> {
        return Repo(ApiData.of(Entity::class))
    }
}





class Repo<Entity : Any>(val api: DataSource<Entity>) {

    fun getAll(success: (response: Response<List<Entity>>) -> Unit,
                        failure: (t: Throwable) -> Unit){
        api.getAll().enqueue(object : Callback<List<Entity>> {
            override fun onResponse(call: Call<List<Entity>>?, response: Response<List<Entity>>) = success(response)
            override fun onFailure(call: Call<List<Entity>>?, t: Throwable) = failure(t)
        })

    }


}