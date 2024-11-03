package com.example.davaleba1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val emailText: EditText = findViewById(R.id.email)
        val recipient: EditText = findViewById(R.id.recipie)
        val  message: EditText = findViewById(R.id.messageEdit)
        val myButton: Button = findViewById(R.id.sendButton)

        myButton.setOnClickListener {
            val emailToSend = emailText.text.toString()
            val recipientToSend = recipient.text.toString()
            val messageToSend = message.text.toString()

            val validationResult = validateInputs(emailToSend, recipientToSend, messageToSend)

            if (validationResult == null){
                val intent = Intent(this, SecondAcivity::class.java)
                intent.putExtra("EmailValue", emailToSend)
                intent.putExtra("RecipientEmailValue", recipientToSend)
                intent.putExtra("MessageValue",messageToSend)
                Toast.makeText(this,"Button Clicked!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else{
                Toast.makeText(this,validationResult,Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(email: String, recipient: String, message: String): String?{
        if (email.isEmpty() || recipient.isEmpty() || message.isEmpty()){
            return  "Email, Recipient's email and message must not be empty."
        }
        if (!email.contains("@")|| !recipient.contains("@")){
            return "Both emails must contain teh '@' symbol"
        }
        if (message.length> 250){
            return "Message cann't exceed 250 characters."
        }
        return null

    }
}