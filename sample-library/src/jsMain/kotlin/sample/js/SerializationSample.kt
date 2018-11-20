package sample.js

import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")

fun main(args: Array<String>) {
    // serializing objects
    val jsonData = JSON.stringify(Data.serializer(), Data(42))
    // serializing lists
    val jsonList = JSON.stringify(Data.serializer().list, listOf(Data(42)))
    println(jsonData) // {"a": 42, "b": "42"}
    println(jsonList) // [{"a": 42, "b": "42"}]

    // parsing data back
    val obj = JSON.parse(Data.serializer(), """{"a":42}""")
    println(obj) // Data(a=42, b="42")
}
