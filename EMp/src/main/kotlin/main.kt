import kotlin.random.Random

fun main() {
    val names = listOf("Федя", "Мотя", "Аркадий", "Федот", "Петя")
    val surNames = listOf("Пупкин", "Хуюпкин", "Лысый", "Белый", "Красный")
    MutableList(10) {
        Employes(names.random(),
            surNames.random(),
            (10000..30000).random())
    }.filter { it.salary > 25000 }.forEach { item ->
        println(item)
    }
}
