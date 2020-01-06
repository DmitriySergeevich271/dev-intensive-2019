package com.example.dev_intensive.Models

import com.example.dev_intensive.Utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
    //var introBit: String = "$firstName $lastName!!!"
    )
{

    //var introBit: String
    //var introBit: String = getIntro()

    constructor(id:String, firstName: String?, lastName: String?): this (
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)

    constructor(id: String): this(id, "John", "Doe")

    init {
        //introBit = getIntro()

        println("It's alive!!!\n" +
                " ${if(lastName == "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"}\n" /*+
                "${getIntro()}"*/)
    }

    /*private fun getIntro() = """
        trash
        turutu
        turutututu
        ${"\n\n\n"}\n
        $firstName $lastName
    """.trimIndent()*/

    /*fun printMe():Unit{
        println("""
            id: $id
            firstName: $firstName
            lastName: $lastName
            avatar: $avatar
            rating: $rating
            respect: $respect
            lastVisit: $lastVisit
            isOnline: $isOnline
        """.trimIndent())
    }*/
    companion object Factory{
        private var lastId: Int = 1
        fun makeUser(fullName: String?): User{
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }
    }
}