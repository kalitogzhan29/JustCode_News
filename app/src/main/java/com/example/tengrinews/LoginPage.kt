package com.example.tengrinews

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import com.example.tengrinews.Database.MainDb
import com.example.tengrinews.databinding.ActivityLogInBinding

class LoginPage : AppCompatActivity(){

    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLogInBinding.inflate(layoutInflater)

       setContentView(binding.root)

       binding.signUpText.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
           startActivity(intent)
       }

        val db = MainDb.getDb(this)
        binding.login1.setOnClickListener {
            val logEmail = findViewById<EditText>(R.id.emaillog).text.toString()
            val logPassword = findViewById<EditText>(R.id.passwordlog).text.toString()

            if (!logEmail.isEmpty() && !logPassword.isEmpty()) {

                db.getDao().getAllItem().asLiveData().observe(this) { list ->
                    var check: Boolean = true
                    list.forEach {
                        if (logEmail.equals(it.email) && logPassword.equals(it.password)) {
                            Log.i(ContentValues.TAG, "${it.password} and ${logPassword}")
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            check = true

                        } else {
                            check = false
                        }
                    }
                    if (!check) {
                        Toast.makeText(
                            this,
                            "Incorrect password or email",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty email or password is not allowed", Toast.LENGTH_SHORT)
                    .show()
            }
       }


    }
}