fun main() {
    val g = Gamer()
    repeat(90){
        println("=============$it")
        if (g.status == Status.WINNER){
            println("ПОБЕДА")
            return
        }
        g.look(it)
        g.ticketList.forEach { item -> item.getTicket() }
        Thread.sleep(1000)
    }
}
