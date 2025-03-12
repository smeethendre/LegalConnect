package com.example.legalapp.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.legalapp.Model.Lawyer
import com.example.legalapp.Model.LawyerViewModel
import com.example.legalapp.R
import com.example.legalapp.adapter.LawyerAdapter

class LawyerActivity : AppCompatActivity(), LawyerAdapter.OnLawyerClickListener {

    private lateinit var viewModel: LawyerViewModel
    private lateinit var lawyerAdapter: LawyerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lawyer_layout)


        viewModel = ViewModelProvider(this)[LawyerViewModel::class.java]


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        setupLawyerRecyclerView()


        observeViewModel()
    }

    private fun setupLawyerRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.lawyers_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        lawyerAdapter = LawyerAdapter(this, emptyList(), this)
        recyclerView.adapter = lawyerAdapter
    }

    private fun observeViewModel() {
        viewModel.lawyers.observe(this) { lawyers ->
            lawyerAdapter.updateData(lawyers)
        }
    }

    override fun onLawyerClick(lawyer: LawyerAdapter.Lawyer?, position: Int) {
        val intent = Intent(this, ChatActivity::class.java).apply {
            putExtra("LAWYER_NAME", lawyer.name)
        }
        startActivity(intent)
    }
}
