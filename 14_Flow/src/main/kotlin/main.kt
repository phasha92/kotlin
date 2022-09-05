fun main() {
    val g = Gamer()
    repeat(100){
        println(it)
        (g as Marker).mark(it)
        g.ticketList.forEach { item -> item.getTicket() }
        Thread.sleep(1000)
    }
}