import kotlin.random.Random
import kotlin.collections.mutableMapOf as mutableMapOf

fun main() {

    var n: Int
    print("Введите N : ")
    do {
        n = readLine()?.toIntOrNull() ?: 0
        if (n <= 0) println("Попробуйте еще раз!")
    } while (n <= 0)

    //телефонная книга
    val phoneBook = createPhoneBookList(n)

    //выводим содержимое Map по шаблону
    for (entry in phoneBook.entries) println("""Абонент: ${entry.value}. Номер телефона ${entry.key}""")

    //выводим только номера телефонов с +7
    println("Выводим только номера телефонов с +7:")
    println(phoneBook.keys.filter { key -> key.startsWith("+7") })

    //выводим количество уникальных телефонов
    println("""Количество уникальных телефонов: ${phoneBook.keys.toSet().size}""")

    //сумма длин всех номеров телефонов
    println("""Сумма длин всех номеров телефонов: ${phoneBook.keys.sumOf { it.length }}""")

    //выводим отсортированное по имени
    println("Сортируем по имени:")
    for (entry in phoneBook.entries.sortedBy { it.value })
        println("""Абонент: ${entry.value}. Номер телефона: ${entry.key}""")

    //выводим отсортированное по номеру телефона
    println("Сортируем по номеру телефона:")
    for (entry in phoneBook.entries.sortedBy { it.key })
        println("""Номер телефона: ${entry.key}. Абонент: ${entry.value}""")
}

//создаем список записей
fun createPhoneBookList(n: Int): Map<String, String> {
    val iList = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val pair: Pair<String, String> = Pair(
            randomPhone(), if (Random.nextBoolean())
                randomNamesMan()
            else
                randomNamesWoman()
        )
        iList[pair.first] = pair.second
    }
    return iList
}

//генерируем номер телефона
fun randomPhone(): String {

    return "+" + Random.nextInt(7, 9).toString() +
            Random.nextInt(900, 999).toString() +
            Random.nextInt(100, 999).toString() +
            Random.nextInt(1000, 9999).toString()
}

//генерируем имена
fun randomNamesMan(): String {
    val name = arrayOf("Павел", "Григорий", "Александр", "Михаил", "Дмитрий", "Андрей", "Евгений", "Семён", "Алексей")
    val patronymic = arrayOf("Леонидович", "Владимирович", "Алексеевич", "Анатольевич",
        "Александрович", "Михаилович", "Дмитриевич", "Андреевич")
    return name.random() + " " + patronymic.random()
}

fun randomNamesWoman(): String {
    val name =
        arrayOf("Анастасия", "Евгения", "Александра", "Дарья", "Анна", "Екатерина", "Елена", "Маргарита", "Любовь")
    val patronymic = arrayOf("Леонидовна", "Владимировна", "Алексеевна", "Анатольевна",
        "Александровна", "Михаиловна", "Дмитриевна", "Андреевна")
    return name.random() + " " + patronymic.random()
}