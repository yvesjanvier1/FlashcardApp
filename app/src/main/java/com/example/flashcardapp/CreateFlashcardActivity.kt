package com.example.flashcardapp

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateFlashcardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_flashcard)

        // Reference all 3 question-answer pairs
        val editQuestion1 = findViewById<EditText>(R.id.edit_question1)
        val editAnswer1 = findViewById<EditText>(R.id.edit_answer1)
        val editQuestion2 = findViewById<EditText>(R.id.edit_question2)
        val editAnswer2 = findViewById<EditText>(R.id.edit_answer2)
        val editQuestion3 = findViewById<EditText>(R.id.edit_question3)
        val editAnswer3 = findViewById<EditText>(R.id.edit_answer3)

        val btnCancel = findViewById<Button>(R.id.btn_cancel)
        val btnDone = findViewById<Button>(R.id.btn_done)

        // Handle Cancel
        btnCancel.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }

        // Handle Done
        btnDone.setOnClickListener {
            val question1 = editQuestion1.text.toString().trim()
            val answer1 = editAnswer1.text.toString().trim()
            val question2 = editQuestion2.text.toString().trim()
            val answer2 = editAnswer2.text.toString().trim()
            val question3 = editQuestion3.text.toString().trim()
            val answer3 = editAnswer3.text.toString().trim()

            // Check if any field is empty
            if (question1.isEmpty() || answer1.isEmpty() ||
                question2.isEmpty() || answer2.isEmpty() ||
                question3.isEmpty() || answer3.isEmpty()) {
                showErrorAlert()
                return@setOnClickListener
            }

            // Pass all 3 pairs back in the Intent
            val resultIntent = Intent().apply {
                putExtra("question1", question1)
                putExtra("answer1", answer1)
                putExtra("question2", question2)
                putExtra("answer2", answer2)
                putExtra("question3", question3)
                putExtra("answer3", answer3)
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun showErrorAlert() {
        AlertDialog.Builder(this)
            .setTitle("Missing Information")
            .setMessage("Please enter all three questions and answers.")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
