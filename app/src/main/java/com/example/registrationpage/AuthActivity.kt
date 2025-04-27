// imports packages
package com.example.registrationpage

// imports libraries
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// creates AuthActivity class that runs auth layout
class AuthActivity : AppCompatActivity() {
    // overrides  abstract superclass function that creates state instance of layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        // creates variables for widgets in auth layout
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        // creates variable for switch button widget
        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        // creates action listener for button click event
        linkToReg.setOnClickListener {
            // creates instance of intent object, intent - object that allows you to move from one activity to another
            val intent = Intent(this, MainActivity::class.java)
            // starts main activity
            startActivity(intent)
        }
        // creates action listener for button click event
        button.setOnClickListener {
            // gets values from text fields and trims spaces
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()
            //if one of the poles in empty shows user message
            if (login.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            else {
                // creates database helper object
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)
                // if user is authorized shows message
                if (isAuth) {
                    Toast.makeText(this, "User $login is authorized", Toast.LENGTH_SHORT).show()
                    // clears text fields after user was added
                    userLogin.text.clear()
                    userPass.text.clear()
                    // if user is authorized starts ItemsActivity
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "User $login is not authorized", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}