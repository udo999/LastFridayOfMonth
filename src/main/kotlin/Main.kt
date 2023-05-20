import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

fun getLastFridayOfMonth(year: Int) {
    for (month in Month.values()) {
        val firstOfMonth = LocalDate.of(year, month, 1)
        val firstWeekday = firstOfMonth.dayOfWeek
        val daysInMonth = month.length(firstOfMonth.isLeapYear)

        val lastFridayDay: Int = when (firstWeekday) {
            DayOfWeek.SUNDAY -> 27
            DayOfWeek.MONDAY -> 26
            DayOfWeek.TUESDAY -> 25
            DayOfWeek.WEDNESDAY -> if (daysInMonth == 31) 31 else 24
            DayOfWeek.THURSDAY -> if (daysInMonth >= 30) 30 else 23
            DayOfWeek.FRIDAY -> if (daysInMonth >= 29) 29 else 22
            DayOfWeek.SATURDAY -> 28
        }

        val lastFriday = LocalDate.of(year, month, lastFridayDay)
        println("$lastFriday (${lastFriday.dayOfWeek}), ${lastFriday.year}")
    }
}

fun main() {
    val year = 2023
    getLastFridayOfMonth(year)
}
