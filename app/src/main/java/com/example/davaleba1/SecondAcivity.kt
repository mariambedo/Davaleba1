package com.example.davaleba1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondAcivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val receivedEmail: EditText = findViewById(R.id.ReceivedEmail)
        val receivedRecipient: EditText = findViewById(R.id.receivedRecipient)
        val receivedMessage: EditText = findViewById(R.id.receivedMessage)
        val clearButton: Button = findViewById(R.id.clearButton)

        val email = intent.getStringExtra("EmailValue")
        val recipientEmail = intent.getStringExtra("RecipientEmailValue")
        val message = intent.getStringExtra("MessageValue")

        receivedEmail.setText(email)
        receivedRecipient.setText(recipientEmail)
        receivedMessage.setText(message)

        clearButton.setOnClickListener {
            receivedEmail.setText("")
            receivedRecipient.setText("")
            receivedMessage.setText("")
        }
    }
}