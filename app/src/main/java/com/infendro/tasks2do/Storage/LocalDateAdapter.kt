package com.infendro.tasks2do.Storage

import com.google.gson.*
import com.infendro.tasks2do.R
import com.infendro.tasks2do.layout.MainActivity
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class LocalDateAdapter : JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    val dtf = DateTimeFormatter.ofPattern(MainActivity.activity.getString(R.string.format_date))

    override fun serialize(
        src: LocalDate?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src?.format(dtf))
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): LocalDate {
        return LocalDate.parse(json?.asString,dtf)
    }

}