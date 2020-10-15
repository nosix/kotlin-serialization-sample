package sample

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ChildData(
    @Contextual val decimal: BigDecimal,
    @Contextual val dateTime: DateTime
)
