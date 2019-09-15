package com.example.kotlinapp.presenter.impl

import com.example.kotlinapp.model.User
import com.example.kotlinapp.presenter.UserDetailsPresenter
import com.example.kotlinapp.view.UserDetailsView

class UserDetailsPresenterImpl(override var view: UserDetailsView?): UserDetailsPresenter<UserDetailsView> {
    override var user: User? = null
        set(value) {
            field = value
            if(field != null){
                view?.showUserDetails(field!!)
            } else {
                view?.showNoUserError()
            }
        }

}
