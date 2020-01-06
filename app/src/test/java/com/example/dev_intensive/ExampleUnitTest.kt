package com.example.dev_intensive

import com.example.dev_intensive.Extensions.TimeUnits
import com.example.dev_intensive.Extensions.add
import com.example.dev_intensive.Extensions.format
import com.example.dev_intensive.Extensions.toUserView
import com.example.dev_intensive.Models.*
import com.example.dev_intensive.Utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "John", "Cena")
        //val user3 = User("3", "John", "Silverhand", null, lastVisit = Date(), isOnline = true)

        //user.printMe()
        //user2.printMe()
        //user3.printMe()

       //println("$user $user2 $user3")
        println("$user")
    }

    @Test
    fun test_factory()
    {
        //val user = User.makeUser("John Cena")
        //val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Wick")
        val user4 = user3.copy(id="3", lastName = "Cena", lastVisit = Date())
        print("$user3\n$user4")

    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")

    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())




        /*if(user.equals(user2))
        {
            println("equals data and hash\n${user.hashCode()} $user\n${user2.hashCode()} $user2")
        }
        else println("not equals data and hash\n${user.hashCode()} $user\n${user2.hashCode()} $user2")

        //user2 = user

        if(user === user2)  //сравнение ссылок
        {
            println("equals data and reference\n${System.identityHashCode(user)} ${java.lang.System.identityHashCode(user2)}")
        }
        else println("not equals data and reference\n${System.identityHashCode(user)} ${java.lang.System.identityHashCode(user2)}")*/

        //user2.lastName = "Doe"
        //println("$user\n$user2")
    }

    @Test
    fun test_data_maping(){
        val user = User.makeUser("Dmitriy Shumskiy")
            val newUser = user.copy(lastVisit = Date().add(-8, TimeUnits.HOUR))
        //println(user)
        println(newUser)

        //val userView = user.toUserView()
        val userView = newUser.toUserView()
        userView.printMe()
        println(Utils.transliteration("Дмитрий Сергеевич Шумский", "_"))
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Dmitriy Shumskiy")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

        /*when(imgMessage){
            is BaseMessage -> println("this is a base message")
            is TextMessage -> println("this is a text message")
            is ImageMessage -> println("this is an image message")
        }*/

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}
