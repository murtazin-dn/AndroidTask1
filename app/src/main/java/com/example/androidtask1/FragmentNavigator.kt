package com.example.androidtask1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

open class FragmentNavigator: Fragment(R.layout.fragment_1) {
    open var name: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = name
        view.findViewById<Button>(R.id.btn_prev).setOnClickListener {
            (requireActivity() as? Router)?.prev()
        }
        view.findViewById<Button>(R.id.btn_next).setOnClickListener {
            (requireActivity() as? Router)?.next()
        }
    }

}