package com.example.legalapp.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject

class LawyerViewModel : ViewModel() {
    private val _lawyers = MutableLiveData<List<Lawyer>>()
    val lawyers: LiveData<List<Lawyer>> = _lawyers

    private val db = FirebaseFirestore.getInstance()

    init {
        loadLawyersFromFirestore()
    }

    private fun loadLawyersFromFirestore() {
        db.collection("lawyers").addSnapshotListener { snapshot, exception ->
            if (exception != null) {
                return@addSnapshotListener
            }

            val lawyerList = mutableListOf<Lawyer>()
            snapshot?.documents?.forEach { document ->
                val lawyer = document.toObject(Lawyer::class.java)
                lawyer?.let {
                    lawyerList.add(it)
                }
            }
            _lawyers.value = lawyerList
        }
    }
}
