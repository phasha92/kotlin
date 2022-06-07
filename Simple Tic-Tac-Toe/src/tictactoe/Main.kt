package tictactoe

const val ZERO = 0
fun main() {
    val battle = createBattle()
    printBattle(battle)
    do {
        move(battle)
        printBattle(battle)
    } while (stage(battle))
}

fun createBattle() = List(3) { MutableList(3) { " " } }

fun move(battle : List<MutableList<String>>) {
    var flag : Boolean
    val mark = if (battle.flatten().count { it == " " } % 2 == ZERO) "O" else "X"
    do {
        flag = true
        try {
            print("Enter the coordinates: ")
            val (x, y) = readln().split(' ').map { it.toInt().dec() }
            if (battle[x][y] == " " || battle[x][y] == "_") {
                battle[x][y] = mark
                flag = false
            } else println("This cell is occupied! Choose another one!")
        } catch (e : NumberFormatException) {
            println("You should enter numbers!")
        } catch (e : IndexOutOfBoundsException) {
            println("Coordinates should be from 1 to 3!")
        }
    } while (flag)
}

fun printBattle(battle : List<List<String>>) {
    println("---------")
    for (i in battle.indices) println("| " + battle[i].joinToString(" ") + " |")
    println("---------")
}

fun stage(battle : List<MutableList<String>>) : Boolean {
    var xCountG = ZERO
    var yCountG = ZERO
    var xCountV = ZERO
    var yCountV = ZERO
    var xCountDl = ZERO
    var yCountDl = ZERO
    var xCountDr = ZERO
    var yCountDr = ZERO
    var winnerX = false
    var winnerY = false
    for (i in battle.indices) {
        for (j in battle[i].indices) {
            if (battle[i][j] == "X") xCountG++
            if (battle[i][j] == "O") yCountG++
            if (battle[j][i] == "X") xCountV++
            if (battle[j][i] == "O") yCountV++
        }
        if (xCountG == battle.size) winnerX = xCountG == battle.size
        if (yCountG == battle.size) winnerY = true
        if (xCountV == battle.size) winnerX = true
        if (yCountV == battle.size) winnerY = true
        xCountG = ZERO
        yCountG = ZERO
        xCountV = ZERO
        yCountV = ZERO
    }
    for (i in battle.indices) {
        if (battle[i][i] == "X") xCountDl++
        if (battle[i][i] == "O") yCountDl++

        if (battle[i][battle.lastIndex - i] == "X") xCountDr++
        if (battle[i][battle.lastIndex - i] == "O") yCountDr++
    }
    if (xCountDl == battle.size) winnerX = true
    if (yCountDl == battle.size) winnerY = true
    if (xCountDr == battle.size) winnerX = true
    if (yCountDr == battle.size) winnerY = true
    if (winnerX) {
        println("X wins")
        return false
    }
    if (winnerY) {
        println("O wins")
        return false
    }
    if (battle.flatten().count { it == " " } == ZERO) {
        println("Draw")
        return false
    }
    return true
}