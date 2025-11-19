package com.example.flashcardapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private var choicesVisible = true

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
        val questionView = findViewById<View>(R.id.flashcard_question)
        val answerView = findViewById<View>(R.id.flashcard_answer)

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
                // Reset all choices to default styled background
                choices.forEach { c ->
                    c.setBackgroundResource(R.drawable.flashcard_answer_bg)
                }

                // Apply feedback with preserved styling
                if (choice == correctAnswer) {
                    choice.setBackgroundResource(R.drawable.choice_correct_bg)
                } else {
                    choice.setBackgroundResource(R.drawable.choice_incorrect_bg)
                }
            }
        }

        // Toggle visibility of answer choices with eye icon
        val toggleBtn = findViewById<ImageButton>(R.id.toggle_choices_btn)
        val choicesViews = arrayOf(choice1, choice2, choice3)

        toggleBtn.setOnClickListener {
            choicesVisible = !choicesVisible
            choicesViews.forEach { it.isVisible = choicesVisible }
            toggleBtn.setImageResource(
                if (choicesVisible) R.drawable.ic_eye else R.drawable.ic_eye_off
            )
        }
    }
}