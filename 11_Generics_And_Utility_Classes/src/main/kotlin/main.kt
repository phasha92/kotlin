

fun main() {

    var n : Int

    do {
        print("Введите колличество итераций : ")
        n = readLine()?.toIntOrNull() ?: 0
        if (n <= 0) println("Попробуйте еще раз!")
        else println("Понеслась! :)")
    } while (n <= 0)

    //test battle


    val battle = Battle()

    for (i in 1..n) {
        if (!battle.endOfBattle)
        battle.iterateTheBattle()
        else break
        println(battle.getBattleStage())
    }
}


