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

// creates main activity class that runs main layout
class MainActivity : AppCompatActivity() {
    // overrides function that creates state instance of layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // creates variables for widgets
        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        // creates action listener for button that switches to auth activity
        linkToAuth.setOnClickListener {
            // creates instance of intent object, intent - object that allows you to move from one activity to another
            val intent = Intent(this, AuthActivity::class.java)
            // starts auth activity
            startActivity(intent)
        }
        // creates action listener for button click event
        button.setOnClickListener {
            // gets values from text fields and trims spaces
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            //if one of the poles in empty shows user message
            if (login.isEmpty() || email.isEmpty() || pass.isEmpty())
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            else {
                // creates User object
                val user = User(login, email, pass)
                // creates DbHelper object
                val db = DbHelper(this, null)
                // calls function that adds user to database
                db.addUser(user)
                // shows message that user was added to database
                Toast.makeText(this, "User $login was added", Toast.LENGTH_SHORT).show()
                // clears text fields after user was added
                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()


            }
        }
    }
}

