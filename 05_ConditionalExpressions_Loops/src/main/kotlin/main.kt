fun main() {
    var n: Int
    do {
        print("Введите значение больше Нуля : ")
        n = readLine()?.toIntOrNull() ?: 0
    } while (n <= 0)
    println("""fibonacci($n) = ${fibonacci(n)}""")
}

fun fibonacci(n: Int): Int {
    if (n == 0 || n == 1) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}