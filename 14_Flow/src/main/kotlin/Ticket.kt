class Ticket {

    val ticket: Array<Array<FieldState>>
    private val ticketNumber: Int

    init {
        count++
        ticketNumber = count
        ticket = ticketCreate()
    }

    fun printTicket() {
        println("    Билет № $ticketNumber")
        print("----------------------------")
        repeat(ticket.size) { i ->
            print("\n|")
            repeat(ticket[i].size) { j ->
                print(ticket[i][j])
                if (ticket[i][j].toString().length == 1)
                    print(" |")
                else
                    print("|")
            }
        }
        println("\n----------------------------")
    }

    companion object {
        private var count = 0

        private fun ticketCreate(): Array<Array<FieldState>> {
            val ticket = mutableListOf<MutableList<FieldState>>()
            val finalTicket = mutableListOf<Array<FieldState>>()
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
                finalTicket.add(ticket[i].toTypedArray())
            }
            return finalTicket.toTypedArray()
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
    }
}
