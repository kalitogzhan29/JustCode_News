package com.example.tengrinews

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tengrinews.Database.Item
import com.example.tengrinews.Database.MainDb
import com.example.tengrinews.databinding.ActivitySignUpBinding

class SignUpPage: AppCompatActivity()  {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db=MainDb.getDb(this)

        binding.button4.setOnClickListener{
            val email = findViewById<EditText>(R.id.emailsign).text.toString()
            val password = findViewById<EditText>(R.id.passwordsign).text.toString()
            val item= Item(
                null,

                email,
                password)

            Thread{
                db.getDao().insertItem(item)
            }.start()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

        binding.logInText.setOnClickListener{
            val intent= Intent(this, LoginPage::class.java)
            startActivity(intent)
        }
    }
}
