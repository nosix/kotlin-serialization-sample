package sample

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexSerializationTests {

    @Test
    fun testComplexDate() {
        val data = ComplexData(
            ChildData(
                BigDecimal("12345678901234567890123456789012345678901234567890"),
                DateTime.now()
            ),
            ChildData(
                BigDecimal("12345678901234567890123456789012345678901234567890.09876543210987654321"),
                DateTime.now()
            )
        )
        val jsonData = format.encodeToString(data)
        println(jsonData)
        val decodedData: ComplexData = format.decodeFromString(jsonData)
        assertEquals(data, decodedData)
    }
}
