package com.think.domain.global

class Request(
    input: String
) {
    val actionName: String
    val paramMap: Map<String, String>

    init {
        val inputBits = input.split("?", limit = 2)
        actionName = inputBits[0]

        paramMap = if (inputBits.size == 2) {
            inputBits[1].split("%").associate {
                val bits = it.split("=", limit = 2)
                bits[0] to bits[1]
            }
        } else {
            emptyMap()
        }
    }

    fun getParam(name: String): String? {
        return paramMap[name]
    }

    fun getParamAsInt(name: String, default: Int): Int {
        return paramMap[name]?.toIntOrNull() ?: default
    }
}