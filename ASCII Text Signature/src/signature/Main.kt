package signature

fun main() {
    val name = input("Enter name and surname: ")
    val status = input("Enter person's status: ")
    Alphabet.printSignature(name, status)
}

// beautiful input :)
fun input(str: String): String {
    print(str)
    return readln()
}