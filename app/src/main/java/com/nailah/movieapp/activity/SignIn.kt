package com.nailah.movieapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import android.view.View
import com.nailah.movieapp.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity(), View.OnClickListener {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var gso: GoogleSignInOptions
    private lateinit var firebaseAuth: FirebaseAuth

    companion object {
        fun getLaunchService(from: Context) = Intent(from, SignInActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        tv_forgot_pass.setOnClickListener(this)
        firebaseAuth = FirebaseAuth.getInstance()

        tv_forgot_pass.setOnClickListener(this)
        tv_sign_up.setOnClickListener(this)
        btn_signin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_forgot_pass -> startActivity(ForgotPasswordActivity.getLaunchService(this))
            R.id.tv_sign_up -> startActivity(
                SignUpActivity.getLaunchService(this)
            )
            R.id.btn_signin -> loginEmailPass()
        }
    }

    private fun loginEmailPass() {
        val email = et_email_signin.text.toString()
        val password = et_pass_signin.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Insert Complete Data", Toast.LENGTH_SHORT).show()
        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    startActivity(MainActivity.getLaunchService(this))
                    return@addOnCompleteListener
                } else {
                    Toast.makeText(this, "Login Sucsess", Toast.LENGTH_SHORT).show()
                    startActivity(MainActivity.getLaunchService(this))

                }
            }.addOnFailureListener {
                val progress = ProgressDialog this, R.style.Theme_AppCompat_Light_Dialog)

                progress.hide() Toast . makeText (this, "Login Gagal", Toast.LENGTH_SHORT).show(

            }

    }

}
