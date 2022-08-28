import java.util.*
import kotlin.random.Random

fun main() {
/*
    val cards = mutableListOf<BankCard>()

    cards.add(TinkoffCredit(Random.nextDouble(1000.0, 10000.0), 10000.0))
    cards.add(SberCredit(Random.nextDouble(1000.0, 10000.0), 20000.0))
    cards.add(AlfaCredit(Random.nextDouble(1000.0, 10000.0), 30000.0))
    cards.add(TinkoffDebit(10000.0))
    cards.add(AlfaDebit(15000.0))
    cards.add((SberDebit(25000.0)))
    for (i in 1..50) {
        println("${i}я итерация==============================")
        for (card in cards.indices) {
            Thread.sleep(1000)
            when (Random.nextInt(0, 2)) {
                0 -> {
                    println(cards[card].name)
                    cards[card].replenish(Random.nextDouble(3000.0, 60000.0))
                    cards[card].getBalanceInfo()
                    println("------------------------------------------")
                }
                1 -> {
                    println(cards[card].name)
                    cards[card].pay(Random.nextDouble(3000.0, 60000.0))
                    cards[card].getBalanceInfo()
                    println("------------------------------------------")
                }
            }
        }
    }*/
   /* repeat(5) { println(func(readLine()!!)) }*/
    val intsList = listOf<Int>(1, 2, 3, 4, 5, 6, 7)
    for (i in 0..11) println(intsList[i])
}

fun func(s: String): Boolean {
    val bras = mapOf('(' to ')', '{' to '}', '[' to ']')
    val stack = Stack<Char>()
    s.forEach {
        if (it in bras.keys) stack.push(it)
        else if (bras[stack.pop()] != it) return false
    }
    return stack.isEmpty()
}
//89218915173