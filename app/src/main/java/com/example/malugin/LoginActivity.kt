package com.example.malugin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import java.util.prefs.Preferences

lateinit var sharedPreferences: SharedPreferences
lateinit var login: EditText
lateinit var password: EditText
lateinit var button: AppCompatButton
class LoginActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        login = findViewById(R.id.loginEdit)
        password = findViewById(R.id.passwordEdit)
        button = findViewById(R.id.buttonLogin)

        var loginPref = sharedPreferences.getString("LOGIN", null)
        var passwordPref = sharedPreferences.getString("PASSWORD", null)


        button.setOnClickListener {
            if (loginPref == null || passwordPref == null) {
                if (!login.text.isEmpty() || !password.text.isEmpty()) {
                    Toast.makeText(this, "Успешная регистрация", Toast.LENGTH_SHORT).show()
                    sharedPreferences.edit().putString("LOGIN", login.text.toString())
                    sharedPreferences.edit().putString("PASSWORD", password.text.toString())
                    startActivity(Intent(this, CalcActivity::class.java))
                } else {
                    Toast.makeText(this, "Найдены пустые строки", Toast.LENGTH_SHORT).show()
                }

            } else if (login.text.toString() == loginPref && password.text.toString() == passwordPref) {
                Toast.makeText(this, "Удачный вход", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CalcActivity::class.java))
            } else {
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }

}

