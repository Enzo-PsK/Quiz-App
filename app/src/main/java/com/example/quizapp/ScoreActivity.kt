package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        var score: Int = intent.extras!!.getInt("final_score")

        setScoreView(score)

        setContentView(binding.root)
    }

    private fun setScoreView(score: Int) {
        binding.tvScore.text = "$score/4"
        when (score) {
            0 -> {
                binding.ivScore.setImageResource(R.drawable.bad_0_0)
                binding.tvMessage.text = "You made batman feel sad"
            }

            1 -> {
                binding.ivScore.setImageResource(R.drawable.sad1_4)
                binding.tvMessage.text = "Captain America is crying, you can do better!"
            }
            2 -> {
                binding.ivScore.setImageResource(R.drawable.ok_2_2)
                binding.tvMessage.text = "That is okay, but do better next time!"
            }
            3 -> {
                binding.ivScore.setImageResource(R.drawable.good_3_4)
                binding.tvMessage.text = "Good work avenger!"
            }
            4 -> {
                binding.ivScore.setImageResource(R.drawable.nice_4_4)
                binding.tvMessage.text = "Excellent work!"
            }
        }
    }
}