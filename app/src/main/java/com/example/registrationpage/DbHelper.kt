// imports packages
package com.example.registrationpage
// import libraries
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// creates DbHelper class that extends SQLiteOpenHelper superclass for creation of database
class DbHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "app", factory, 1) {
    // overrides abstract superclass function that creates database, abstract function must be implemented
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                login TEXT NOT NULL,
                email TEXT NOT NULL,
                pass TEXT NOT NULL
            )
            
            """.trimIndent()
        )
    }

    // overrides abstract superclass function that updates database, abstract function must be implemented
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        // executes sql query for updating database - removes table if exists
        db!!.execSQL("DROP TABLE IF EXISTS users")
        // calls function that creates database
        onCreate(db)
    }

    // creates function that ads User to database
    fun addUser(user: User) {
        //  creates objects for storing sql user values
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("pass", user.pass)
        // creates sql query for adding user, writeableDatabase - returns writable database
        val db = this.writableDatabase
        // executes sql query to add user to database
        db.insert("users", null, values)
        // closes database
        db.close()
    }

    // creates function that gets User from database
    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE login = ? AND pass = ?",
            arrayOf(login, pass)
        )
        val userExists = cursor.moveToFirst()
        cursor.close()
        return userExists
    }
}