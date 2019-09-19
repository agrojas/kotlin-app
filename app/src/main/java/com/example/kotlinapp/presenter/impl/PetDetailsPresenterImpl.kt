package com.example.kotlinapp.presenter.impl

import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.presenter.PetDetailsPresenter
import com.example.kotlinapp.view.PetDetailsView

class PetDetailsPresenterImpl(override var view: PetDetailsView?) : PetDetailsPresenter<PetDetailsView> {
    override var pet: Pet? = null
        set(value) {
            field = value
            if (field != null) {
                view?.showPetDetails(field!!)
            } else {
                view?.showNoPetError()
            }
        }

}
