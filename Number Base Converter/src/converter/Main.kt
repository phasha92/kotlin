package converter
import java.math.MathContext
import java.math.RoundingMode
fun main() {
    do {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ")
        val command = readln().split(' ')
        if (command.first() != "/exit") {
            do {
                print("Enter number in base ${command.first()} to convert to base ${command.last()} (To go back type /back) ")
                val input = readln()
                if (input != "/back") println("Conversion result: ${
                    convertTo(convertToTen(input, command.first()),
                        command.last())
                }\n")
                else break
            } while (true)
        } else break
    } while (true)
}
fun convertToTen(x : String, y : String) : String {
    val rangeTarget = (('0'..'9') + ('a'..'z')).joinToString("")
    val targetFrom = y.toBigDecimal()
    if (!x.contains('.')) return x.toBigInteger(y.toInt()).toString(10)
    val number = if ('.' in x) x else "$x.0"
    val razryad = number.split('.').last().length
    var tenSystem = (0).toBigDecimal()
    val element = number.split('.').joinToString("").reversed()
    val element1 = mutableListOf<Int>()
    for (i in 0..element.length.dec())
        element1.add(rangeTarget.indexOf(element[i]))
    for (i in 0 until number.length.dec())
        tenSystem = tenSystem
                .plus(targetFrom.pow(i - razryad, MathContext.DECIMAL64)
                    .multiply(element1[i]
                        .toBigDecimal())).setScale(5, RoundingMode.HALF_DOWN)
        return tenSystem.toString()
}
fun convertTo(x : String, y : String) : String {
    val rangeTarget = (('0'..'9') + ('a'..'z')).joinToString("")
    val targetToX = y.toBigDecimal()
    var numberDouble = ("0." + x.split('.').last()).toBigDecimal()
    var numberInt = x.split('.').first()
    var targetSystem = ""
    repeat(numberDouble.toString().length) {
        numberDouble *= targetToX
        targetSystem += rangeTarget[numberDouble.toInt()]
        numberDouble = ("0." + numberDouble.toString().split('.').last()).toBigDecimal()
    }
    numberInt = numberInt.toBigInteger(10).toString(y.toInt())
    if (!x.contains('.')) return numberInt
    return "$numberInt.${targetSystem.take(5)}"
}
