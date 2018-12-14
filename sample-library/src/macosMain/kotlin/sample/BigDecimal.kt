package sample

actual data class BigDecimal actual constructor(private val value: String) : Comparable<BigDecimal> {
    override fun toString(): String = value
    override fun compareTo(other: BigDecimal): Int = compareValues(value, other)
}
