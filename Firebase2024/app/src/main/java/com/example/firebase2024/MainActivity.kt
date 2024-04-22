package com.example.firebase2024

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebase2024.ui.theme.Firebase2024Theme

import com.google.firebase.Firebase
import com.google.firebase.database.database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Firebase2024Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }

        // Write a message to the database - Message / Hello World
        val database = Firebase.database
        //val myRef = database.getReference("message")
        //myRef.setValue("Hello World!")

        // Write to the database after importing employee.json
        val myRef = database.getReference("employees")
        val emp = Employee("Ninja", "Christelle")
        myRef.push().setValue(emp)

        // Read from the database
        /*myRef.addValueEventListener(object: ValueEventListener {

             override fun onDataChange(snapshot: DataSnapshot) {
                 // This method is called once with the initial value and again
                 // whenever data at this location is updated.
                 val value = snapshot.getValue<String>()
                 Log.d("MAINACTIVITY", "Value is: " + value)
             }

             override fun onCancelled(error: DatabaseError) {
                 Log.w("MAINACTIVITY", "Failed to read value.", error.toException())
             }

         })*/

        val myRef1 = database.getReference().child("employees")
        myRef1.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var counter = 0;
                for (ds in snapshot.children) {
                    var emp = ds.getValue<Employee>()
                    // Checking the type of Employee
                    //if (emp is Employee){
                    //   Log.d("MAINACTIVITY", "Employee")
                    //}
                    // Use the if or use !! to be sure that emp is not null
                    //if (emp != null) {
                        Log.d(
                            "MAINACTIVITY",
                            "firstname: " + emp!!.firstName + " lastNAme: " + emp!!.lastName
                        )
                    //} else {
                    //    Log.d("MAINACTIVITY", "Employee is null")
                    //}
                    counter += 1
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("MAINACTIVITY", "Failed to read value.", error.toException())
            }
        })
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Firebase2024Theme {
        Greeting("Android")
    }
}

// Employee class
data class Employee(val firstName: String? = null, val lastName: String? = null) {
}
