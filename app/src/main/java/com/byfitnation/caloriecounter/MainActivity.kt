package com.byfitnation.caloriecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.byfitnation.caloriecounter.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var firebaseAuth : FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.tvCreateAccountSignIn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        binding.btnSignIn.setOnClickListener {
            validateData()
        }

    }
    private fun validateData() {
        email = binding.etEmailSignIn.text.toString().trim()
        password = binding.etPasswordSignIn.text.toString().trim()

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etEmailSignIn.error = "invalid format "
        }
        else if(TextUtils.isEmpty(password)){
            binding.etPasswordSignIn.error = "Please enter password"
        }
        else{
            firebaseSignIn()
        }

    }
    private fun firebaseSignIn() {
        firebaseAuth.signInWithEmailAndPassword(email , password )
            .addOnSuccessListener {
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email

                Toast.makeText(this, "Sign in succesfull as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()

            }
            .addOnFailureListener {
                Toast.makeText(this, "Sign in failed ", Toast.LENGTH_SHORT).show()
            }
    }
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }


}