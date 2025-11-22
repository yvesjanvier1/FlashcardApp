package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private var choicesVisible = true

    // ✅ Modern way to handle activity results
    private val createFlashcardLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val newQuestion = data?.getStringExtra("question") ?: "Tap to study!"
            val newAnswer = data?.getStringExtra("answer") ?: ""

            // Update main flashcard views
            findViewById<TextView>(R.id.flashcard_question).text = newQuestion
            findViewById<TextView>(R.id.flashcard_answer).text = "The correct answer is: '$newAnswer'"

            // Update MCQ: set choice3 as correct answer
            findViewById<TextView>(R.id.choice3).text = newAnswer

            // Reset MCQ styling
            val choices = listOf(
                findViewById<View>(R.id.choice1),
                findViewById<View>(R.id.choice2),
                findViewById<View>(R.id.choice3)
            )
            choices.forEach { it.setBackgroundResource(R.drawable.flashcard_answer_bg) }

            // Reset visibility state
            findViewById<View>(R.id.flashcard_answer).isVisible = false
            choices.forEach { it.isVisible = true }
            choicesVisible = true
            findViewById<ImageButton>(R.id.toggle_choices_btn).setImageResource(R.drawable.ic_eye)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Flashcard toggle (question ↔ answer)
        val questionView = findViewById<TextView>(R.id.flashcard_question)
        val answerView = findViewById<TextView>(R.id.flashcard_answer)

        questionView.setOnClickListener {
            questionView.isVisible = false
            answerView.isVisible = true
        }

        answerView.setOnClickListener {
            answerView.isVisible = false
            questionView.isVisible = true
        }

        // Multiple choice answers with styled feedback
        val choice1 = findViewById<View>(R.id.choice1)
        val choice2 = findViewById<View>(R.id.choice2)
        val choice3 = findViewById<View>(R.id.choice3)
        val choices = listOf(choice1, choice2, choice3)
        val correctAnswer = choice3 // "Barack Obama"

        for (choice in choices) {
            choice.setOnClickListener {
                // Reset all choices
                choices.forEach { c ->
                    c.setBackgroundResource(R.drawable.flashcard_answer_bg)
                }
                // Apply feedback
                if (choice == correctAnswer) {
                    choice.setBackgroundResource(R.drawable.choice_correct_bg)
                } else {
                    choice.setBackgroundResource(R.drawable.choice_incorrect_bg)
                }
            }
        }

        // Toggle visibility of answer choices
        val toggleBtn = findViewById<ImageButton>(R.id.toggle_choices_btn)
        val choicesViews = arrayOf(choice1, choice2, choice3)

        toggleBtn.setOnClickListener {
            choicesVisible = !choicesVisible
            choicesViews.forEach { it.isVisible = choicesVisible }
            toggleBtn.setImageResource(
                if (choicesVisible) R.drawable.ic_eye else R.drawable.ic_eye_off
            )
        }

        // ➕ Add new flashcard
        val fabAdd = findViewById<ImageButton>(R.id.fab_add)
        fabAdd.setOnClickListener {
            val intent = Intent(this, CreateFlashcardActivity::class.java)
            createFlashcardLauncher.launch(intent)
        }

        // ✏️ Edit current flashcard
        val btnEdit = findViewById<ImageButton>(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val currentQuestion = questionView.text.toString()
            val fullAnswerText = answerView.text.toString()
            val currentAnswer = if (fullAnswerText.startsWith("The correct answer is: '")) {
                fullAnswerText
                    .removePrefix("The correct answer is: '")
                    .removeSuffix("'")
            } else {
                fullAnswerText
            }

            val intent = Intent(this, CreateFlashcardActivity::class.java).apply {
                putExtra("prefill_question", currentQuestion)
                putExtra("prefill_answer", currentAnswer)
            }
            createFlashcardLauncher.launch(intent)
        }
    }
}