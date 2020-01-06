package com.example.dev_intensive.Extensions

import com.example.dev_intensive.Models.User
import com.example.dev_intensive.Models.UserView
import com.example.dev_intensive.Utils.Utils
import java.lang.Math.abs
import java.util.*

fun User.toUserView(): UserView{

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online"
    else "Последний раз был ${lastVisit.humanizeDiff()}"  //разница между временем текущего экземпляра и временем, которое
                                                          //передано в качестве аргумента (типа 2 дня назад)

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status)
}

fun Date.humanizeDiff(date:Date = Date()): String{
    val seconds = (this.time - date.time) / 1000
    val minutes = (seconds / 60).toInt()
    val hours = (minutes / 60).toInt()
    return when(seconds) {
        in 0 until 1 -> "только что"
        in -1 until 0 -> "только что"
        in -45 until -1 -> "несколько секунд назад"
        in 1 until 45 -> "через несколько секунд"
        in -75 until -45 -> "минуту назад"
        in 45 until 75 -> "через минуту"
        in -300 until -75 -> "${abs(minutes)} минуты назад"
        in 75 until 300 -> "через $minutes минуты"
        in -2700 until -300 -> "${abs(minutes)} минут назад"
        in 300 until 45 * 60 -> "через ${abs(minutes)} минут"
        in -4500 until -2700 -> "час назад"
        in 45 * 60 until 75 * 60 -> "через час"
        in -18000 until -4500 -> "${abs(hours)} часа назад"
        in 75 * 60 until 5 * 60 * 60 -> "через $hours часа"
        in -79200 until -18000 -> "${abs(hours)} часов назад"
        in 5 * 60 * 60 until 22 * 60 * 60 -> "через $hours часов"
        in -93600 until -79200 -> "день назад"
        in 22 * 60 * 60 until 26 * 60 * 60 -> "через день"
        in -31104000 until -93600 -> "${abs(hours / 24)} дней назад"
        in 26 * 60 * 60 until 360 * 24 * 60 * 60 -> "через ${abs(hours / 24)} дней"
        in 360 * 24 * 60 * 60 until 2147483648 -> "через несколько лет"
        else -> "более года назад"
    }
}

/*private fun Date.humanizeDiff(date:Date = Date()): String{
    val diff: Long = date.time - time
            val seconds = abs(this.time - date.time) / 1000
            val minutes = 1 + (seconds - 16) / 60
            val hours = 1 + (minutes - 16) / 60
        return when(seconds) {
            in 0..1 -> "только что"
            in 1..45 -> "несколько секунд назад"
            in 46..75 -> "минуту назад"
            in 75..195 -> "$minutes минуты назад"
            in 195..45 * 60 -> "$minutes минут назад"
            in 45 * 60..75 * 60 -> "час назад"
            in 75 * 60..4 * 60 * 60 -> "$hours часа назад"
            in 4 * 60 * 60..22 * 60 * 60 -> "$hours часов назад"
            in 22 * 60 * 60..26 * 60 * 60 -> "день назад"
            in 26 * 60 * 60..360 * 24 * 60 * 60 -> "${hours / 24} дней назад"
            else -> "более года назад"
        }
}*/