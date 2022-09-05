class Ticket {

    val ticket = mutableListOf<MutableList<FieldState>>()
    private val ticketNumber: Int

    init {
        count++
        ticketNumber = count
        val busy = mutableListOf<Int>()
        var element: Int
        repeat(3) { i ->
            val randomIndex = randomIndex()
            ticket.add(mutableListOf())
            repeat(9) {
                if (it in randomIndex) {
                    ticket[i].add(FieldState.Open)
                } else {
                    do {
                        element = it.inc() * 10 - (0..9).random()
                    } while (element in busy)
                    ticket[i].add(FieldState.Number(element))
                    busy.add(element)
                }
            }
        }
    }

    fun getTicket() {
        println("    Билет № $ticketNumber")
        print("----------------------------")
        for (i in 0 until ticket.size) {
            print("\n|")
            for (j in 0 until ticket[i].size) {
                print(ticket[i][j])
                if (ticket[i][j].toString().length == 1)
                    print(" |")
                else
                    print("|")
            }
        }
        println("\n----------------------------")
    }

    private fun randomIndex(): List<Int> {
        val indexList = mutableListOf<Int>()
        var index: Int
        do {
            index = (0..8).random()
            if (index !in indexList) indexList.add(index)
        } while (indexList.size < 4)
        return indexList.toList()
    }

    companion object {
        private var count = 0
        fun ticketCreate() = Ticket()
    }
}
