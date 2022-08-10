package com.danish.android.translator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.danish.android.translator.data.DefinitionsItem
import com.danish.android.translator.data.ResponseItem
import com.danish.android.translator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(TranslatorViewModel::class.java)


        viewModel.searchWord.observe(this){
        Log.i("searchWord","caused  : ${it}")
           binding.tvWord.text = it.word
           binding.tvPhonetics.text = it.phonetic

            setupRecyclerView(it)

        }

        binding.svFind.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.getDataApi(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

    }

    fun setupRecyclerView(arrayList: ResponseItem){
         binding.rvDefinition.apply {
             val mAdapter = TranslatorAdapter()
             layoutManager = LinearLayoutManager(this@MainActivity)
             adapter = mAdapter
             mAdapter.setData(arrayList.meanings?.get(0)?.definitions as List<DefinitionsItem>)
         }
    }
}