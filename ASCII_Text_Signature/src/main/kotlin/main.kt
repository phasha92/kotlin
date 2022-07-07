import Searcher.fileSearch
import java.io.File


fun main() {/*
    val name = input("Enter name and surname: ")
    val status = input("Enter person's status: ")
    Alphabet.printSignature(name, status)*/

    val roman = fileSearch(File("D:/Lessons/Android/AndroidKotlin/gitHub/kotlin/ASCII_Text_Signature/src/"), "roman")

    val medium = fileSearch(File("D:/Lessons/Android/AndroidKotlin/gitHub/kotlin/ASCII_Text_Signature/src/"), "medium")
    println(File(medium).readText())
}

// beautiful input :)
fun input(str: String): String {
    print(str)
    return readln()
}


