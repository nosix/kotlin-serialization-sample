package sample

import java.math.BigDecimal as JvmBigDecimal

actual class BigDecimal actual constructor(value: String) : Comparable<BigDecimal> {
    private val value = JvmBigDecimal(value)

    override fun equals(other: Any?): Boolean {
        return other is BigDecimal && value == other.value
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    override fun toString(): String = value.toString()

    override fun compareTo(other: BigDecimal): Int = value.compareTo(other.value)
}