package com.example.kotlinapp.presenter.impl

import android.util.Log
import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.presenter.PetPresenter
import com.example.kotlinapp.repository.Repository
import com.example.kotlinapp.view.PetsView
import retrofit2.Response

class PetPresenterImpl(override var view: PetsView?): PetPresenter<PetsView> {


    private val TAG = PetPresenterImpl::class.java.simpleName

    private val repository = Repository.of<Pet>()

    override fun findPets() {
        repository.getAll(this::handleResponse, this::handleError)
    }

    private fun handleResponse(response: Response<List<Pet>>) {
        if (response.isSuccessful) {
            Log.i(TAG, "Response is Successful!")
            view?.showPets(response.body().orEmpty())
        } else if (!response.isSuccessful){
            view?.showPetsError(response.errorBody())
        }
    }

    private fun handleError(error: Throwable) {
        Log.e(TAG, error.localizedMessage)
        view?.showPetsError(error)
    }

    override fun showPetDetails(pet: Pet) {
        view?.showPetDetails(pet)
    }

}