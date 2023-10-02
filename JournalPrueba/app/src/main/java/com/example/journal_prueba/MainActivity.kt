package com.example.journal_prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: JournalEntryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddEntry : Button = findViewById(R.id.buttonAddEntry)
        val buttonSearch : Button = findViewById(R.id.buttonSearch)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = JournalEntryAdapter(emptyList())
        recyclerView.adapter = adapter

        buttonAddEntry.setOnClickListener {
            // Inicia la actividad para agregar una nueva entrada
            val intent = Intent(this, AddJournal::class.java)
            startActivity(intent)
        }

        buttonSearch.setOnClickListener {
            // Inicia la actividad para agregar una nueva entrada
            val intent = Intent(this, SearchJournal::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        // Recupera las entradas de diario desde la base de datos
        val dbHelper = DbHelper(this)
        val journalEntries = dbHelper.getAllJournalEntries()

        // Actualiza el adaptador con las entradas recuperadas
        adapter.updateData(journalEntries)
        Log.d("MiApp", "Número de entradas recuperadas: ${journalEntries.size}")
    }

}