class Gamer(countTicket: Int = 3): Marker {
    val ticketList = List(countTicket) { Ticket() }
    var status: Status = Status.EXPECTATION
    val gamerNumber: Int

    init {
        countGamers++
        gamerNumber = countGamers
    }

    override fun mark(x: Int) {
        repeat(ticketList.size) {
            repeat(ticketList[it].ticket.size) { i ->
                repeat(ticketList[it].ticket[i].size) { j ->
                    if (ticketList[it].ticket[i][j] is FieldState.Number)
                        if (ticketList[it].ticket[i][j].toString() == "$x") {
                            ticketList[it].ticket[i][j] = FieldState.Close
                            return
                        }
                }
            }
        }
    }

    fun look(x: Int) {
        if (status == Status.EXPECTATION) {
            repeat(ticketList.size) {
                if (ticketList[it].ticket.flatten().count { item -> item == FieldState.Close } == X_COUNT) {
                    status = Status.WINNER
                    return
                }
                mark(x)
            }
        }
    }

    companion object {
        const val X_COUNT = 15
        var countGamers = 0
    }
}