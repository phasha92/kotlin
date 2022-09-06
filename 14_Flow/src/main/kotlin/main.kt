import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow

fun main() {
    val players = List(3) { Gamer() }
    var flag = false
    runBlocking {
        Generator.flow().collect {
            println("выпал номер $it")
            players.forEach { player ->
                println("player ${player.gamerNumber}")
                scope.launch {
                    with(player) {
                        look(it)
                        if (this.status == Status.WINNER) {
                            println("победил игрок $gamerNumber")
                            flag = true
                            this@launch.cancel()
                        } else
                            ticketList.forEach { item -> item.printTicket() }
                    }
                    if (flag) this@runBlocking.cancel()
                }
                delay(1)
            }
        }
    }
    println("end")
}

val scope = CoroutineScope(Job() + Dispatchers.Default)

object Generator {
    fun flow() = (1..90).shuffled().asFlow()
}