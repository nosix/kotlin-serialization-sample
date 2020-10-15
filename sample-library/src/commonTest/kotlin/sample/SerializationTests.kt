package sample

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlin.test.Test
import kotlin.test.assertEquals

class SerializationTests {

    @Test
    fun testObjectSerialization() {
        val data = Data(42, "50")
        val jsonData = format.encodeToString(data)
        assertEquals("""{"a":42,"b":"50"}""", jsonData)
        val decodedData: Data = format.decodeFromString(jsonData)
        assertEquals(data, decodedData)
    }

    @Test
    fun testListSerialization() {
        val data = listOf(Data(42))
        val jsonData = format.encodeToString(data)
        assertEquals("""[{"a":42}]""", jsonData)
        val decodedData: List<Data> = format.decodeFromString(jsonData)
        assertEquals(data, decodedData)
    }
}
