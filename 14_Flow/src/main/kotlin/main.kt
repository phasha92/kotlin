fun main() {
    val g = List(3) { Gamer() }
    repeat(90) {
        println("=============${it.inc()}")
        repeat(g.size) { i ->
            if (g[i].status == Status.WINNER) {
                println("ПОБЕДА ИГРОКА ${g[i].gamerNumber}")
                g[i].ticketList.forEach { item -> item.printTicket() }
                return
            } else {
                println("Игрок № ${g[i].gamerNumber}")
                g[i].look(it)
                g[i].ticketList.forEach { item ->
                    item.printTicket()
                }
                //Thread.sleep(1000)
            }
        }
    }
}
