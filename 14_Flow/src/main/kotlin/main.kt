
fun main() {
    val players = List(30000) { Gamer(10) }
    Simulator.loto(players)
}