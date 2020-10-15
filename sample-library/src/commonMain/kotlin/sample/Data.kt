package sample

import kotlinx.serialization.Serializable

@Serializable
data class Data(val a: Int, val b: String = "42")
