package sample

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable

@Serializable
data class Data(val a: Int, @Optional val b: String = "42")
