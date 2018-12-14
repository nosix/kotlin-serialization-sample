package sample

import com.soywiz.klock.DateTime
import kotlinx.serialization.Serializable

@Serializable
data class ChildData(
        val decimal: BigDecimal,
        val dateTime: DateTime
)
