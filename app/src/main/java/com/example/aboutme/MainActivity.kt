package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Adham Ahmed")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main) view binding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) //data binding
        binding.myName=myName
//        findViewById<Button>(R.id.button_text).setOnClickListener{
//            addNickName(it)
//        }
        binding.doneButton.setOnClickListener{
            addNickName(it)
        }

    }

    private fun addNickName(view: View?) { // the param passed is the "done" button clicked
        binding.apply {
            myName?.nickName= binding.nicknameEdit.text.toString()
            invalidateAll() // refresh UI with the new data
            nicknameEdit.visibility=View.GONE
            doneButton.visibility=View.GONE
            nicknameText.visibility=View.VISIBLE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}