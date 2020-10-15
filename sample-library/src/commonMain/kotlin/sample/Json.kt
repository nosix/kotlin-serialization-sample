package sample

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual

val format = Json {
    serializersModule = SerializersModule {
        contextual(BigDecimalSerializer)
        contextual(DateTimeSerializer)
    }
}