package com.example.kotlinapp.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinapp.R
import com.example.kotlinapp.model.User
import com.example.kotlinapp.presenter.CreateUserPresenter
import com.example.kotlinapp.presenter.impl.CreateUserPresenterImpl
import com.example.kotlinapp.view.USER_KEY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CreateUserView {

    private val presenter: CreateUserPresenter<CreateUserView> by lazy{
        CreateUserPresenterImpl(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveUserBtn.setOnClickListener {
            presenter.saveUser(userName.text.toString(), userSurname.text.toString())
        }
    }

    override fun showEmptyNameError() {
        userName.error = getString(R.string.name_empty_error) /* it's equal to userName.setError() -
Kotlin allows us to use property */

    }

    override fun showEmptySurnameError() {
        userSurname.error = getString(R.string.surname_empty_error)
    }

    override fun showUserSaved() {
        Toast.makeText(applicationContext, R.string.user_saved,  Toast.LENGTH_SHORT).show()
    }

    override fun showUserDetails(user: User) {
        val intent = Intent(this, UserDetailsActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }
    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}
