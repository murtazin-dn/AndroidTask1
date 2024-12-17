package com.example.androidtask1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Router {

    private var currentId = 0

    private val fragments = listOf<Fragment>(
        Fragment1(),
        Fragment2(),
        Fragment3()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragments[currentId])
                .commit()
        }
    }

    override fun next() {
        val id = if (currentId >= fragments.size - 1) 0 else currentId + 1
        currentId = id
        navigateTo(id)
    }

    override fun prev() {
        val id = if (currentId == 0) fragments.size - 1 else currentId - 1
        currentId = id
        navigateTo(id)
    }

    private fun navigateTo(id: Int){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragments[id])
            .commit()
    }
}