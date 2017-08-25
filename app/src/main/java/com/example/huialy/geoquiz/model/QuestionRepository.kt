package com.example.huialy.geoquiz.model

import com.example.huialy.geoquiz.R

/**
 * Created by tangminghui on 2017/8/22.
 */
object QuestionRepository {

    var mCurrentIndex: Int = 0
    var cheatCount: Int = 0

    private val mQuestionBank = mutableListOf(
            Question(R.string.question_africa,true),
            Question(R.string.question_oceans,true),
            Question(R.string.question_mideast,false),
            Question(R.string.question_americas,true),
            Question(R.string.question_asia,true)
    )

    fun currentQuestion() = mQuestionBank[modCurrentIndex()]

    private fun modCurrentIndex(): Int {
        while (mCurrentIndex < 0) {
            mCurrentIndex += mQuestionBank.size
        }
        return mCurrentIndex % mQuestionBank.size
    }

    fun completeQuestion(isAnswerRight: Boolean) {
        val question = mQuestionBank[modCurrentIndex()]
        question.isAnswer = true
        question.isAnswerRight = isAnswerRight
        mQuestionBank[modCurrentIndex()] = question
    }

    fun isCompleteAllQuestion(): Boolean = mQuestionBank.filter { !it.isAnswer }.isEmpty()

    fun score(): String = (mQuestionBank.filter { it.isAnswerRight }.size * 100 / mQuestionBank.size).toString() + "%"

    fun cheatAnswer() {
        cheatCount++
    }

}