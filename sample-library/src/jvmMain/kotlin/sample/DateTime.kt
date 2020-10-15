package sample

import java.util.*

actual class DateTime actual constructor(epochTime: Long) : Comparable<DateTime> {
    private val value = Date(epochTime)
    actual val epochTime = value.time

    override fun equals(other: Any?): Boolean {
        return other is DateTime && epochTime == other.epochTime
    }

    override fun hashCode(): Int {
        return epochTime.hashCode()
    }

    override fun toString(): String {
        return epochTime.toString()
    }

    override fun compareTo(other: DateTime): Int = value.compareTo(other.value)

    actual companion object {
        actual fun now(): DateTime = DateTime(Date().time)
    }
}