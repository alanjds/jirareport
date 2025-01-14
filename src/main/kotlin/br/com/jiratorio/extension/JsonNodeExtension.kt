package br.com.jiratorio.extension

import com.fasterxml.jackson.databind.JsonNode

fun JsonNode?.extractValueNotNull(): String =
    this.extractValue()!!

fun JsonNode?.extractValue(): String? {
    if (this == null || this.isNull || this.isMissingNode) {
        return null
    }

    if (this.isObject) {
        return if (this.hasNonNull("value"))
            this.path("value").extractValue()
        else
            this.path("name").extractValue()
    }

    if (this.isArray) {
        return this.joinToString {
            it.extractValue() ?: ""
        }
    }

    return this.asText(null)
}
