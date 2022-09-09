import kotlinx.coroutines.*
import kotlinx.coroutines.flow.cancellable

object Simulator {

    fun loto(players: List<Gamer>) {
        val winners = mutableListOf<Gamer>()
        var flag = false
        runBlocking {
            players.forEach { player ->
                launch {
                    Generator.flow.cancellable().collect {
                        with(player) {
                            if (status == Status.WINNER) {
                                println("Игрок № $gamerNumber выиграл!")
                                flag = true
                                winners.add(this)
                                cancel()
                            } else {
                                println("Игрок ${player.gamerNumber} смотрит $it")
                                look(it)
                            }
                            ticketList.forEach { item ->
                                item.printTicket()
                            }
                            if (flag) cancel()
                        }
                    }
                }
            }
        }
        winners.let {
            println("Список победителей: ")
            it.forEach { item ->
                println("Игрок № ${item.gamerNumber}")
            }
        }
        println("""боченков было выброшено ${Generator.count / players.size}
            |количество победителей ${winners.size}
        """.trimMargin())
    }
}
