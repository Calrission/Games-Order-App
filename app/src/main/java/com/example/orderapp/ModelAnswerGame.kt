package com.example.orderapp

data class ModelAnswerGame(
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<Game>
)