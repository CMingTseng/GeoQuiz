package com.example.huialy.geoquiz

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.huialy.geoquiz.model.Question
import com.example.huialy.geoquiz.model.QuestionRepository
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlin.properties.Delegates

class QuizActivity : AppCompatActivity() {

    var currentQuestion: Question by Delegates.observable(QuestionRepository.currentQuestion()){
        _, _, _ ->
        refreshUI()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }

    private fun refreshUI() {
        question_text.text = getString(QuestionRepository.currentQuestion().textResId)
        true_button.isEnabled = ! currentQuestion.isAnswer
        false_button.isEnabled = ! currentQuestion.isAnswer
        if (QuestionRepository.cheatCount >= 3) {
            cheat_button.isEnabled = false
            Toast.makeText(this,R.string.judgment_toast,Toast.LENGTH_SHORT).show()
        }
        if (QuestionRepository.isCompleteAllQuestion())
            Toast.makeText(this,QuestionRepository.score(),Toast.LENGTH_SHORT).show()
    }

    fun showResult(view: View) {
        val myAnswer = view.id == R.id.true_button
        val isAnswerRight = myAnswer == currentQuestion.answerTrue
        QuestionRepository.completeQuestion(isAnswerRight)
        val resId = if (isAnswerRight) R.string.correct_toast else R.string.incorrect_toast
        val show: Any = Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
        currentQuestion = QuestionRepository.currentQuestion()
    }

    fun nextQuestion(view: View) {
        QuestionRepository.mCurrentIndex++
        currentQuestion = QuestionRepository.currentQuestion()
    }

    fun prevQuestion(view: View) {
        QuestionRepository.mCurrentIndex--
        currentQuestion = QuestionRepository.currentQuestion()
    }

    fun startCheatActivity(view: View) = startActivity(Intent(this,CheatActivity::class.java))

}
