
enum class Alphabet(val ASCII: List<String>) {
    A(listOf("____", "|__|", "|  |")),
    B(listOf("___ ", "|__]", "|__]")),
    C(listOf("____", "|   ", "|___")),
    D(listOf("___ ", "|  \\", "|__/")),
    E(listOf("____", "|___", "|___")),
    F(listOf("____", "|___", "|   ")),
    G(listOf("____", "| __", "|__]")),
    H(listOf("_  _", "|__|", "|  |")),
    I(listOf("_", "|", "|")),
    J(listOf(" _", " |", "_|")),
    K(listOf("_  _", "|_/ ", "| \\_")),
    L(listOf("_   ", "|   ", "|___")),
    M(listOf("_  _", "|\\/|", "|  |")),
    N(listOf("_  _", "|\\ |", "| \\|")),
    O(listOf("____", "|  |", "|__|")),
    P(listOf("___ ", "|__]", "|   ")),
    Q(listOf("____", "|  |", "|_\\|")),
    R(listOf("____", "|__/", "|  \\")),
    S(listOf("____", "[__ ", "___]")),
    T(listOf("___", " | ", " | ")),
    U(listOf("_  _", "|  |", "|__|")),
    V(listOf("_  _", "|  |", " \\/ ")),
    W(listOf("_ _ _", "| | |", "|_|_|")),
    X(listOf("_  _", " \\/ ", "_/\\_")),
    Y(listOf("_   _", " \\_/ ", "  |  ")),
    Z(listOf("___ ", "  / ", " /__"));

    companion object {
        private const val SPACE = "    "
        private const val INDENT = 2
        fun printSignature(name: String, status: String) {
            // interpreter name
            val line = List(3) { mutableListOf<String>() }
            for (ch in name.uppercase()) {
                if (ch == ' ') line.forEach { it.add(SPACE) } else
                    valueOf(ch.toString()).run { line.forEachIndexed { i, ln -> ln.add(ASCII[i]) } }
            }
            val print = Array(3) { i -> line[i].joinToString(" ") }
            // print stars
            val asteriskLine = {
                println("*".repeat(maxOf(print[0].length, status.length)
                        + INDENT * 2 + 2))
            }

            // indents: left - false / right - true
            fun statusIndent(right: Boolean = false): String {
                val ind = maxOf(print[0].length - status.length + INDENT * 2, INDENT * 2)
                return " ".repeat(ind / 2 + if (right) ind % 2 else 0)
            }

            fun fontIndent(right: Boolean = false): String {
                val ind = status.length - print[0].length
                return " ".repeat(maxOf(INDENT, ind / 2 + INDENT + if (right) ind % 2 else 0))
            }

            asteriskLine()
            print.forEach { println("*${fontIndent()}$it${fontIndent(true)}*") }
            println("*${statusIndent()}$status${statusIndent(true)}*")
            asteriskLine()
        }
    }
}