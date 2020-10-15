package sample

import kotlin.math.sign

actual data class DateTime actual constructor(actual val epochTime: Long) : Comparable<DateTime> {
    override fun compareTo(other: DateTime): Int = (epochTime - other.epochTime).sign

    actual companion object {
        actual fun now(): DateTime = DateTime(0)
    }
}