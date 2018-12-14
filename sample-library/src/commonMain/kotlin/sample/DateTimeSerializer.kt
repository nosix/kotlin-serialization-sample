package sample

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.soywiz.klock.parse
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

// FIXME IllegalStateException: Class DateTime is not externally serializable
@Serializer(forClass = DateTime::class)
object DateTimeSerializer : KSerializer<DateTime> {

    private val format = DateFormat("yyyy-MM-dd'T'hh:mm:ss")

    override fun serialize(output: Encoder, obj: DateTime) {
        output.encodeString(obj.format(format))
    }

    override fun deserialize(input: Decoder): DateTime {
        return format.parse(input.decodeString()).utc
    }
}
