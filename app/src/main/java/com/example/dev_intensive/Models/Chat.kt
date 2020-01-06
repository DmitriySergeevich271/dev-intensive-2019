package com.example.dev_intensive.Models

class Chat (
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}