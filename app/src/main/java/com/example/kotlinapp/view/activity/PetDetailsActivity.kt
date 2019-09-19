package com.example.kotlinapp.view.activity


import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.kotlinapp.R
import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.presenter.PetDetailsPresenter
import com.example.kotlinapp.presenter.impl.PetDetailsPresenterImpl
import com.example.kotlinapp.presenter.impl.PetPresenterImpl
import com.example.kotlinapp.utils.PET_KEY
import com.example.kotlinapp.view.PetDetailsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pet_details.*

class PetDetailsActivity : AppCompatActivity(), PetDetailsView {
    private val TAG = PetPresenterImpl::class.java.simpleName

    private val presenter: PetDetailsPresenter<PetDetailsView> by lazy {
        PetDetailsPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_details)

        val pet = intent.getParcelableExtra<Pet>(PET_KEY)
        presenter.pet = pet
    }

    override fun showPetDetails(pet: Pet) {
        pet_details_id.text = "ID: ${pet.id}"
        pet_details_name.text = "Name: ${pet.name}"
        pet_details_status.text = "Status: ${pet.status}"
        //pet.photoUrls[0]
        Log.i(TAG, pet.photoUrls.first())
        Picasso.get().load(pet.photoUrls.first()).into(pet_details_image);

    }

    override fun showNoPetError() {
        Toast.makeText(this, "No Pet Error", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}