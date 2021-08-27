package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginTop
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var questions = ArrayList<Question>()
    var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnNext.setOnClickListener {
            validateAnswer()
        }

        //Starting preset
        startPresets()
        addFirstQuestion()

        setContentView(binding.root)
    }

    private fun validateAnswer() {
        when (binding.tvQuestionNumber.text) {
            "Quiz #01" -> {
                var textView: TextView? =
                    findViewById(binding.answerRadioGroup.checkedRadioButtonId)
                var selectedText = textView?.text
                if (selectedText == "Hulk") {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT)
                        .show()
                    score += 1
                }
                if (selectedText != "Hulk") {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT)
                        .show()
                }
                addSecondQuestion()
            }
            "Quiz #02" -> {
                if ((binding.cbGi.isChecked && binding.cbMam.isChecked && binding.cbWm.isChecked) && !binding.cbMs.isChecked) {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    score += 1
                } else {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                }
                addThirdQuestion()
            }
            "Quiz #03" -> {
                if (binding.etQuestion3.text.toString() == "Carol Danvers") {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    score += 1
                } else {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                }
                addFourthQuestion()
            }
            "Quiz #04" -> {
                var textView: TextView? =
                    findViewById(binding.answerRadioGroupQuestion4.checkedRadioButtonId)
                var selectedText = textView?.text
                if (selectedText == "True") {
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                    score += 1
                } else {
                    Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                }
                endGame()
            }
        }

    }

    private fun startPresets() {
        questions.add(Question(1, "Who is this superhero?", R.drawable.hulk, "Hulk"))
        questions.add(Question(2, "What are this superhero 'powers'?", R.drawable.batman, "NULL"))
        questions.add(
            Question(
                3,
                "What is the real name of this superheroine?\nHint: type below like this pattern: Captain Marvel",
                R.drawable.cpt_marvel,
                "Carol Danvers"
            )
        )
        questions.add(
            Question(
                4,
                "This superhero used to carry an infinite stone?",
                R.drawable.dr_strange,
                "True"
            )
        )
    }

    private fun addFirstQuestion() {
        binding.tvQuestionNumber.text = "Quiz #0${questions[0].number}"
        binding.tvQuestion.text = questions[0].text
        binding.ivHero.setImageResource(questions[0].image)
    }

    private fun addSecondQuestion() {
        binding.answerRadioGroup.visibility = View.GONE
        binding.vgQuestion2.visibility = View.VISIBLE
        binding.tvQuestionNumber.text = "Quiz #0${questions[1].number}"
        binding.tvQuestion.text = questions[1].text
        binding.ivHero.setImageResource(questions[1].image)
    }

    private fun addThirdQuestion() {
        binding.vgQuestion2.visibility = View.GONE
        binding.etQuestion3.visibility = View.VISIBLE
        binding.tvQuestionNumber.text = "Quiz #0${questions[2].number}"
        binding.tvQuestion.text = questions[2].text
        binding.ivHero.setImageResource(questions[2].image)

    }

    private fun addFourthQuestion() {
        binding.etQuestion3.visibility = View.GONE
        binding.answerRadioGroupQuestion4.visibility = View.VISIBLE
        binding.tvQuestionNumber.text = "Quiz #0${questions[3].number}"
        binding.tvQuestion.text = questions[3].text
        binding.ivHero.setImageResource(questions[3].image)

    }

    private fun endGame() {
        println("SCORE IS GOING TO INTENT IS: $score")
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("final_score", score)
        startActivity(intent)
    }

}