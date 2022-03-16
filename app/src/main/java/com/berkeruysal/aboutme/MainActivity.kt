package com.berkeruysal.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.berkeruysal.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName=MyName("Berker Uysal")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName
        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }
    }
    private fun addNickname(view: View)
    {
        binding.apply {
            nameText.text=binding.nicknameEdit.text
            invalidateAll()
            nicknameEdit.visibility=View.VISIBLE
            buttonDone.visibility=View.GONE
            nameText.visibility=View.VISIBLE
        }


        val hideKeyboard=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideKeyboard.hideSoftInputFromWindow(view.windowToken,0)
    }
}