package cinema

fun main() {
    val cinema = createCinema()

    do {
        println("""1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
""")
        val command = readln()
        when (command) {
            "1" -> printCinema(cinema)
            "2" -> buyTicket(cinema)
            "3" -> statistics(cinema)
        }
    } while (command != "0")
}

fun statistics(cinema: MutableList<MutableList<String>>) {
    val purCashed = cinema.flatten().count { it == "B" }
    val percentage = purCashed.toDouble() / cinema.flatten().count { it == "B" || it == "S" } * 100
    val formatPercentage = String.format("%.2f", percentage)
    println("""Number of purchased tickets: $purCashed
Percentage: $formatPercentage%
Current income: ${'$'}${showTicketPrice(cinema)}
Total income: ${allPrice(cinema)}
""")
}

fun allPrice(cinema: MutableList<MutableList<String>>): String {
    val rows = cinema.size.dec()
    val seats = cinema.first().size.dec()
    return when {
        rows * seats < 60 -> "$${rows * seats * 10}"
        rows % 2 == 0 -> "$${rows / 2 * seats * (8 + 10)}"
        else -> "$${(rows / 2 + 1) * seats * 8 + (rows / 2) * seats * 10}"
    }
}

fun printCinema(cinema: MutableList<MutableList<String>>) {
    println("Cinema:")
    for (i in 0 until cinema.size)
        println(cinema[i].joinToString(" "))
    println()
}

fun createCinema(): MutableList<MutableList<String>> {
    val cinema = mutableListOf<MutableList<String>>()
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    val s = mutableListOf(" ")
    // заполняем первую строку
    for (i in 1..seats) s.add(i.toString())
    cinema.add(s)
    // заполняем остальные
    for (i in 1..rows) {
        cinema.add(mutableListOf())
        for (j in 0..seats) {
            val str = if (cinema[i].isEmpty()) i.toString() else "S"
            cinema[i].add(str)
        }
    }
    // печать
    println()
    return cinema
}

fun buyTicket(cinema: MutableList<MutableList<String>>) {
    try {
        println("Enter a row number:")
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        val seat = readln().toInt()
        if (cinema[row][seat] == "B") throw Exception("\nThat ticket has already been purchased!\n")
        val result = when {
            cinema.size.dec() * cinema[0].lastIndex < 60 -> 10
            else -> if (row in cinema.size / 2..cinema.size) 8
            else 10
        }
        cinema[row][seat] = "B"
        println("\nTicket price: $$result\n")
    } catch (e : IndexOutOfBoundsException) {
        println("\nWrong input!\n")
        buyTicket(cinema)
    } catch (e : Exception) {
        println(e.message)
        buyTicket(cinema)
    }

}

fun showTicketPrice(cinema: MutableList<MutableList<String>>): Int {
    val rows = cinema.size.dec()
    val seats = cinema.first().size.dec()
    var current = 0
    for (i in 1..rows)
        for (j in 1..seats)
            current += if (cinema[i][j] == "B") when {
                rows * seats < 60 -> 10
                else -> if (i in cinema.size / 2..cinema.size) 8
                else 10
            } else 0
    return current
}