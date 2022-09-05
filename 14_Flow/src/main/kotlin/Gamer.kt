class Gamer(countTicket: Int = 3): Marker {
    val ticketList = List(countTicket) { Ticket() }
    override fun mark(x:Int) {
        repeat(ticketList.size){ i ->
            repeat(ticketList[i].ticket.size){ j ->
                repeat(ticketList[i].ticket[j].size){
                    if (ticketList[i].ticket[j][it] is FieldState.Number)
                        if (ticketList[i].ticket[j][it].toString() == "$x") ticketList[i].ticket[j][it] = FieldState.Close
                }
            }
        }
    }
}