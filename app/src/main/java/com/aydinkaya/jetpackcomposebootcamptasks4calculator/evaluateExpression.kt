package com.aydinkaya.jetpackcomposebootcamptasks4calculator


fun evaluateExpression(expression: String): Double {
    return try {
        val tokens = expression.split("(?<=[-+*/])|(?=[-+*/])".toRegex())
        var result = tokens[0].toDouble()
        var index = 1

        while (index < tokens.size) {
            val operator = tokens[index]
            val nextNumber = tokens[index + 1].toDouble()
            result = when (operator) {
                "+" -> result + nextNumber
                "-" -> result - nextNumber
                "*" -> result * nextNumber
                "/" -> result / nextNumber
                else -> result
            }
            index += 2
        }
        result
    } catch (e: Exception) {
        0.0
    }
}
