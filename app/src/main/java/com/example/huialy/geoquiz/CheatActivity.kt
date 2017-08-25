package com.example.huialy.geoquiz

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.huialy.geoquiz.model.Question
import com.example.huialy.geoquiz.model.QuestionRepository
import kotlinx.android.synthetic.main.activity_cheat.*

class CheatActivity : AppCompatActivity() {

    val currentQuestion: Question by lazy { QuestionRepository.currentQuestion() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
    }

    fun showAnswer(view: View) {
        QuestionRepository.cheatAnswer()
        if (currentQuestion.isAnswerRight) {
            answer_text_view.setText(R.string.true_button)
        }else {
            answer_text_view.setText(R.string.false_button)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            show animator
        }else {
//            invisible view
        }
    }
}
