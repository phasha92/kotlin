import kotlin.random.Random

class Ticket {

    private val ticket = mutableListOf<MutableList<FieldState>>()

    init {
        val busy = mutableListOf<Int>()
        var element: Int
        for (i in 0..2) {
            ticket.add(mutableListOf())
            for (j in 0..4) {
                do {
                    element = Random.nextInt(1, 91)
                    if (element !in busy)
                        ticket[i].add(FieldState.Number(element))
                } while (element in busy)
                busy.add(element)
            }
            for (g in 0..3)
                ticket[i].add(FieldState.Open)
            ticket[i].shuffle()
        }
    }

    fun getTicket() {
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

}
