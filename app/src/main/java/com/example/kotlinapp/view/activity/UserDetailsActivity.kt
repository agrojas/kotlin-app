package com.example.kotlinapp.view.activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlinapp.R
import com.example.kotlinapp.model.User
import com.example.kotlinapp.presenter.UserDetailsPresenter
import com.example.kotlinapp.presenter.impl.UserDetailsPresenterImpl
import com.example.kotlinapp.view.USER_KEY
import com.example.kotlinapp.view.UserDetailsView
import kotlinx.android.synthetic.main.activity_user_details.*

class UserDetailsActivity: AppCompatActivity(), UserDetailsView {

    private val presenter: UserDetailsPresenter<UserDetailsView> by lazy {
        UserDetailsPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val user = intent.getParcelableExtra<User>(USER_KEY)
        presenter.user = user
    }

    override fun showUserDetails(user: User) {
        userFullName.text = "${user.name} ${user.surname}"
    }

    override fun showNoUserError() {
        Toast.makeText(applicationContext, R.string.no_user_error,  Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}