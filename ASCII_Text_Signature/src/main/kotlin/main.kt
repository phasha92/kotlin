import Searcher.fileSearch
import java.io.File


fun main() {
    val name = input("Enter name and surname: ")
    val status = input("Enter person's status: ")
    Fonts.printSignature(name, status)
}

// beautiful input :)
fun input(str: String): String {
    print(str)
    return readln()
}
// Happy Birthday Elena Naloyka

