class Gamer(countTicket: Int = 3): Marker {
    val ticketList = List(countTicket) { Ticket() }
    override fun mark() {
        println()
    }
}