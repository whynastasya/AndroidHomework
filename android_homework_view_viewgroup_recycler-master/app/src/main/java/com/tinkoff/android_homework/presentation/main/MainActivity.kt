package com.tinkoff.android_homework.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tinkoff.android_homework.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var operationsRecyclerView: RecyclerView
    private lateinit var totalSum: TextView
    private lateinit var outcome: TextView
    private lateinit var income: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operationsRecyclerView = findViewById(R.id.operations_recycler)

        totalSum = findViewById(R.id.sum)
        outcome = findViewById(R.id.outcome)
        income = findViewById(R.id.income)
        progressBar = findViewById(R.id.progress_bar)

        initOperationsRecycler()

        subscribeToOperations()
        subscribeToTotal()

    }

    private fun subscribeToTotal() {
        lifecycleScope.launch {
            viewModel.total.collect { totalItem ->
                income.text = totalItem?.income.toString()
                outcome.text = totalItem?.outcome.toString()
                totalSum.text = totalItem?.total.toString()

                Log.e("TAGRTRT", "totalItem?.progress :${totalItem?.progress}")
                progressBar.progress = totalItem?.progress?.toInt() ?: 0
            }
        }
    }

    private fun subscribeToOperations() {
        lifecycleScope.launch {
            viewModel.operations.collect {
                // TODO Добавить сущности операций в адаптер
            }
        }
    }

    private fun initOperationsRecycler() {
        //  TODO Добавить адаптер для ресайклера
        operationsRecyclerView.layoutManager = LinearLayoutManager(baseContext)
    }
}
