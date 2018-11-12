package com.lcorozco10.tvg

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnLogin: Button
    private lateinit var edtUserName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var usernameWrapper: TextInputLayout
    private lateinit var passwordWrapper: TextInputLayout
    private lateinit var textInfo: TextView
    private lateinit var progressBar: ProgressBar


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textInfo = findViewById(R.id.linkSignup)
        edtUserName = findViewById(R.id.edtUserName)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        usernameWrapper = findViewById(R.id.usernameWrapper)
        passwordWrapper = findViewById(R.id.passwordWrapper)


        btnLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when {
            p0?.id == R.id.btnLogin -> {
                val userName = edtUserName.text.toString()
                val password = edtPassword.text.toString()

                if (!validateUser(userName)) {
                    val userNameError = getString(R.string.userNameError)
                    usernameWrapper.error = userNameError
                } else if (!validatePassword(password)) {
                    val passwordError = getString(R.string.PasswordError)
                    passwordWrapper.error = passwordError
                } else if (userName == "lcorozco" && password == "123456") {

                    val inputManager:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.SHOW_FORCED)
                    usernameWrapper.isErrorEnabled = false
                    passwordWrapper.isErrorEnabled = false
                    btnLogin.isEnabled =  false
                    progressBar()

                } else {
                    usernameWrapper.isErrorEnabled = false
                    passwordWrapper.isErrorEnabled = false
                    val error = getString(R.string.InvaliUser)
                    toast(error)
                }
            }
        }
    }

    private fun validateUser(userName: String): Boolean {
        return userName.length > 4
    }

    private fun validatePassword(password: String): Boolean {
        return password.length > 5
    }

    // Extension of Toast
    private fun Context.toast(message: CharSequence) =
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    private fun progressBar(){
        progressBar = this.progressBarExample

        // task is run on a thread
        Thread(Runnable {
            // dummy thread mimicking some operation whose progress cannot be tracked

            // display the indefinite progressbar
            this@LoginActivity.runOnUiThread(java.lang.Runnable {
                progressBar.visibility = View.VISIBLE
            })

            // performing some dummy time taking operation
            try {

                Thread.sleep(2600)

            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            // when the task is completed, make progressBar gone
            this@LoginActivity.runOnUiThread(java.lang.Runnable {

                progressBar.visibility = View.GONE
                toast("Welcome.")
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Username", edtUserName.text)
                startActivity(intent)
                btnLogin.isEnabled =  true
            })
        }).start()

    }

}
