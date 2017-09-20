package com.example.huialy.geoquiz.model

import com.example.huialy.geoquiz.R
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Created by hui on 2017/9/20.
 */
class QuestionRepositoryTest {


    @Test
    fun currentQuestion() {

        QuestionRepository.mCurrentIndex = 2
        val result = QuestionRepository.currentQuestion()
        val expect = Question(R.string.question_mideast,false,true,true)
        Assert.assertEquals(expect,result)
    }

    @Test
    fun isCompleteAllQuestion() {
        for (i in 0..4) {
            QuestionRepository.mCurrentIndex = i
            QuestionRepository.completeQuestion(true)
        }
        val result = QuestionRepository.isCompleteAllQuestion()
        val expect = true
        Assert.assertEquals(expect,result)
    }

    @Test
    fun score() {
        val result = QuestionRepository.score()
        val expect = "100%"
        Assert.assertEquals(expect,result)
    }

}