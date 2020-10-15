package sample

expect class DateTime(epochTime: Long) : Comparable<DateTime> {
    val epochTime: Long

    companion object {
        fun now(): DateTime
    }
}