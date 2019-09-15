package com.example.kotlinapp.view

import com.example.kotlinapp.model.User

interface View


interface CreateUserView: View {
    fun showEmptyNameError() /* show error when name is empty */
    fun showEmptySurnameError() /* show error when surname is empty */
    fun showUserSaved() /* show user saved info */
    fun showUserDetails(user: User) /* show user details */
}

interface UserDetailsView: View {
    fun showUserDetails(user: User)
    fun showNoUserError()
}