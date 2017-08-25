package com.example.huialy.geoquiz.model

/**
 * Created by tangminghui on 2017/8/22.
 */
//data class Question {
//    var textResId: Int,
//    var answerTrue: Boolean
//}

data class Question(var textResId: Int,var answerTrue: Boolean,var isAnswerRight: Boolean = false,var isAnswer: Boolean = false){}