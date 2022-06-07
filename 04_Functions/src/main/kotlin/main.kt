fun main() {
    // зашифрованное сообщение
    val testText : String = "F2p)v" + '"' + "y233{0->c}ttelciFc"
    // расшифрованное сообщение
    val output : String?
    // соединяем расшифрованное сообщение
    output = firstHalfString(testText) + secongHalfString(testText)
    println(
        """testText = $testText
        |output = $output
    """.trimMargin()
    )

}

// первая половина шифра
fun firstHalfString(str : String) : String {
//выбираем первую половину сообщения
    var firstHalf : String = str.dropLast(str.length / 2)

    //  var a = { param:String,param2:Int->param.map { char->char + param2 }.joinToString("")}//лямда выражение
    //firstHalf=a(firstHalf,1)


    //сдвигаем на 1 символ вправо
   // firstHalf = shift(firstHalf) { it.map { char -> char + 1 }.joinToString("") }
    firstHalf = shift(firstHalf) { char -> char +1}
    //заменяем 5 на s
    firstHalf = firstHalf.replace('5', 's')

    //заменяем 4 на u
    firstHalf = firstHalf.replace('4', 'u')

    //сдвигаем на 3 символа влево
  //  firstHalf = shift(firstHalf) { it.map { char -> char - 3 }.joinToString("") }
    firstHalf = shift(firstHalf) { it -3}
    //заменяем 0(Ноль) на o
    firstHalf = firstHalf.replace('0', 'o')

    //возвращаем функции значение
    return firstHalf
}

// вторая половина шифра
fun secongHalfString(str : String) : String {

    //выбираем вторую половину сообщения
    var secondHalf : String = str.drop(str.length / 2)

    //разворачиваем
    secondHalf = secondHalf.reversed()

    //сдвигаем на 4 символа влево
    secondHalf = shift(secondHalf)  { it  -4}

    //заменяем символ подчеркивания на пробел
    secondHalf = secondHalf.replace('_', ' ')

    //возващаем функции значение
    return secondHalf
}

/*функция высшего порядка
на входе строка и функция
на выходе строка*/

fun shift(sourceString : String, func : (Char) -> Char) : String {
    return sourceString.map(func).joinToString("")
}


