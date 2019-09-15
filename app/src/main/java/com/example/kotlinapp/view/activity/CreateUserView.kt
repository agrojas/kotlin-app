package com.example.kotlinapp.view.activity

import com.example.kotlinapp.model.User
import com.example.kotlinapp.view.View


interface CreateUserView : View {
    fun showEmptyNameError()
    fun showEmptySurnameError() /* show error when surname is empty */
    fun showUserSaved() /* show user saved info */
    fun showUserDetails(user: User) /* show user details */

}