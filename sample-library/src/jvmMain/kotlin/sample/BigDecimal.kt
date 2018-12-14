package sample

import java.math.BigDecimal as JvmBigDecimal

actual class BigDecimal actual constructor(value: String) : Comparable<BigDecimal> {
    private val value = JvmBigDecimal(value)
    override fun toString(): String = value.toString()
    override fun compareTo(other: BigDecimal): Int = value.compareTo(other.value)
}
