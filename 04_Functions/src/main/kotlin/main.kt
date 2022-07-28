fun main() {
    // зашифрованное сообщение
    val inputText = "F2p)v\"y233{0->c}ttelciFc"
    // расшифрованное сообщение
    val output: String?
    // соединяем расшифрованное сообщение
    output = firstHalfString(inputText) + secongHalfString(inputText)
    println(
        """inputText = $inputText
        |output = $output
    """.trimMargin()
    )
}

// первая половина шифра
fun firstHalfString(str: String) = str.dropLast(str.length / 2)
    .shift { it + 1 }
    .replace('5', 's')
    .replace('4', 'u')
    .shift { it - 3 }
    .replace('0', 'o')

// вторая половина шифра
fun secongHalfString(str: String) = str.drop(str.length / 2).reversed()
    .shift { it - 4 }.replace('_', ' ')

/*функция высшего порядка
на входе строка и функция
на выходе строка*/

fun String.shift(func: (Char) -> Char): String {
    return this.map(func).joinToString("")
}


