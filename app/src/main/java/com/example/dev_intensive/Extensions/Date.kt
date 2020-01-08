package com.example.dev_intensive.Extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
    this.time = time
    return this
}

fun Date.plural(value: Int, units: TimeUnits = TimeUnits.SECOND): String{
        if (units == TimeUnits.SECOND && value %10 == 1) return "$value секунду назад"
        else if (units == TimeUnits.SECOND && value % 10 in 2..4) return "$value секунды назад"
        else if (units == TimeUnits.SECOND && (value % 10 in 5..9|| value % 10 == 0)) return "$value секунд назад"
        else if (units == TimeUnits.MINUTE && value %10 == 1) return "$value минуту назад"
        else if (units == TimeUnits.MINUTE && value % 10 in 2..4) return "$value минуты назад"
        else if (units == TimeUnits.MINUTE && (value % 10 in 5..9|| value % 10 == 0)) return "$value минут назад"
        else if (units == TimeUnits.HOUR && value %10 == 1) return "$value час назад"
        else if (units == TimeUnits.HOUR && value % 10 in 2..4) return "$value часа назад"
        else if (units == TimeUnits.HOUR && (value % 10 in 5..9|| value % 10 == 0)) return "$value часов назад"
        else if (units == TimeUnits.DAY && value %10 == 1) return "$value день назад"
        else if (units == TimeUnits.DAY && value % 10 in 2..4) return "$value дня назад"
        else if (units == TimeUnits.DAY && (value % 10 in 5..9|| value % 10 == 0)) return "$value дней назад"
        else throw IllegalStateException("invalid unit")
    }

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}