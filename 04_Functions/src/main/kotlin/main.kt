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
fun firstHalfString(str: String): String {
//выбираем первую половину сообщения
    return str.dropLast(str.length / 2)
        .map { it+1 }.joinToString("")
        .replace('5', 's')
        .replace('4', 'u')
        .map { it -3 }.joinToString ( "" )
        .replace('0', 'o')
}

// вторая половина шифра
fun secongHalfString(str: String): String {

    //выбираем вторую половину сообщения
    var secondHalf: String = str.drop(str.length / 2)

    //разворачиваем
    secondHalf = secondHalf.reversed()

    //сдвигаем на 4 символа влево
    secondHalf = shift(secondHalf) { it - 4 }

    //заменяем символ подчеркивания на пробел
    secondHalf = secondHalf.replace('_', ' ')

    //возвращаем функции значение
    return secondHalf
}

/*функция высшего порядка
на входе строка и функция
на выходе строка*/

fun shift(sourceString: String, func: (Char) -> Char): String {
    return sourceString.map(func).joinToString("")
}


