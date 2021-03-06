package sample

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object DateTimeSerializer : KSerializer<DateTime> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DateTime", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: DateTime) {
        encoder.encodeLong(value.epochTime)
    }

    override fun deserialize(decoder: Decoder): DateTime {
        return DateTime(decoder.decodeLong())
    }
}