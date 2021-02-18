package com.infendro.tasks2do.Storage

import com.google.gson.*
import com.infendro.tasks2do.R
import com.infendro.tasks2do.layout.MainActivity
import java.lang.reflect.Type
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalTimeAdapter : JsonSerializer<LocalTime>, JsonDeserializer<LocalTime> {

    val dtf = DateTimeFormatter.ofPattern(MainActivity.activity.getString(R.string.format_time))

    override fun serialize(
        src: LocalTime?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src?.format(dtf))
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalTime {
        return LocalTime.parse(json?.asString,dtf)
    }
}