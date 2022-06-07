
fun main() {

    var n : Int

    do {

    println("Введите значение больше Нуля : ")

        n  = readLine()?.toIntOrNull() ?: return

    } while (n <= 0 )

    println("""fibonachi($n) = ${fibonachi(n-1)}""")
}

fun fibonachi(n : Int) : Int {

    if (n == 0 || n == 1) return n

    //присвоение предыдущих значений по формуле
    return fibonachi(n-1)+fibonachi(n-2)

}


