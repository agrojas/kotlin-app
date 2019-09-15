package com.example.kotlinapp.presenter.impl

import com.example.kotlinapp.model.User
import com.example.kotlinapp.model.UserError
import com.example.kotlinapp.model.UserStore
import com.example.kotlinapp.model.UserValidator
import com.example.kotlinapp.presenter.CreateUserPresenter
import com.example.kotlinapp.view.activity.CreateUserView

class CreateUserPresenterImpl(override var view: CreateUserView?):
    CreateUserPresenter<CreateUserView> {
    override fun saveUser(name: String, surname: String) {
        val user = User(name, surname)
        when(UserValidator.validateUser(user)){
            UserError.EMPTY_NAME -> view?.showEmptyNameError()
            UserError.EMPTY_SURNAME -> view?.showEmptySurnameError()
            UserError.NO_ERROR -> {
                UserStore.saveUser(user)
                view?.showUserSaved()
                view?.showUserDetails(user)
            }
        }
    }

}