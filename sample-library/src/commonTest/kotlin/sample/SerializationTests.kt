package sample

import kotlinx.serialization.UpdateMode
import kotlinx.serialization.json.JSON
import kotlinx.serialization.list
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTests {

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
    fun testSerialize() {
        val jsonData = json.stringify(Data.serializer(), Data(42))
        assertEquals("""{"a":42,"b":"42"}""", jsonData)
        val jsonList = json.stringify(Data.serializer().list, listOf(Data(42)))
        assertEquals("""[{"a":42,"b":"42"}]""", jsonList)
    }

    @Test
    fun testDeserialize() {
        val obj = JSON.parse(Data.serializer(), """{"a":42}""")
        assertEquals(Data(a=42, b="42"), obj)
    }
}
