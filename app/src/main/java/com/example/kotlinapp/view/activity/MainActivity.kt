package com.example.kotlinapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import android.widget.Toast
import com.example.kotlinapp.R
import com.example.kotlinapp.adapter.PetAdapter
import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.presenter.PetPresenter
import com.example.kotlinapp.presenter.impl.PetPresenterImpl
import com.example.kotlinapp.utils.PET_KEY
import com.example.kotlinapp.view.PetsView
import okhttp3.ResponseBody

class MainActivity : AppCompatActivity(), PetsView {


    private val presenter: PetPresenter<PetsView> by lazy {
        PetPresenterImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.findPets()
    }

    override fun showPets(pets: List<Pet>) {
        val lv = findViewById<ListView>(R.id.list_pet)
        lv.adapter = PetAdapter(this, ArrayList(pets), presenter)
    }

    override fun showPetsError(error: Throwable) {
        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    override fun showPetsError(error: ResponseBody?) {
        Toast.makeText(this, "Error ${error.toString()}", Toast.LENGTH_SHORT).show()
    }


    override fun showPetDetails(pet: Pet) {
        val intent = Intent(this, PetDetailsActivity::class.java).apply {
            putExtra(PET_KEY, pet)
        }
        startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

}
