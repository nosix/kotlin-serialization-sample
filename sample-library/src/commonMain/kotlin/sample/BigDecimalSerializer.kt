package sample

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

// FIXME IllegalStateException: Class DateTime is not externally serializable
@Serializer(forClass = BigDecimal::class)
object BigDecimalSerializer: KSerializer<BigDecimal> {

    override fun serialize(output: Encoder, obj: BigDecimal) {
        output.encodeString(obj.toString())
    }

    override fun deserialize(input: Decoder): BigDecimal {
        return BigDecimal(input.decodeString())
    }
}
