package sample

import com.soywiz.klock.DateTime
import com.soywiz.klock.days
import kotlinx.serialization.UpdateMode
import kotlinx.serialization.json.JSON
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ComplexSerializationTests {

    private lateinit var json: JSON

    @BeforeTest
    fun setUp() {
        json = JSON(
                unquoted = false,
                indented = false,
                indent = "    ",
                strictMode = true,
                updateMode = UpdateMode.OVERWRITE,
                encodeDefaults = true)
    }

    @Test
    fun testComplexDate() {
        val data = ComplexData(
                ChildData(
                        BigDecimal("12345678901234567890123456789012345678901234567890"),
                        DateTime.now()
                ),
                ChildData(
                        BigDecimal("12345678901234567890123456789012345678901234567890.09876543210987654321"),
                        DateTime.now() + 1.days
                )
        )
        val json = JSON.stringify(ComplexData.serializer(), data)
        println(json)
        val deserializedData = JSON.parse(ComplexData.serializer(), json)
        assertEquals(data, deserializedData)
    }
}