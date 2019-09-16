package com.example.kotlinapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kotlinapp.R
import com.example.kotlinapp.model.Pet
import com.example.kotlinapp.presenter.PetPresenter
import com.example.kotlinapp.view.PetsView

class PetAdapter(context:Context, val dataSource: ArrayList<Pet>, presenter: PetPresenter<PetsView>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val presenter: PetPresenter<PetsView> = presenter

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_pet, parent, false)
        val idTextView = rowView.findViewById(R.id.pet_list_id) as TextView
        val statusTextView = rowView.findViewById(R.id.pet_list_status) as TextView
        val nameTextView = rowView.findViewById(R.id.pet_list_name) as TextView
        val pet = this.getItem(position)
        idTextView.text = pet.id.toString()
        statusTextView.text = pet.status
        nameTextView.text = pet.name
        rowView.setOnClickListener {
            presenter.showPetDetails(pet)
        }
        return rowView
    }

    override fun getItem(position: Int): Pet {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }
}