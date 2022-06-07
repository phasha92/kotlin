import kotlin.random.Random
import kotlin.collections.mutableMapOf as mutableMapOf


fun main() {

    var n : Int

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
    println("""Колличество уникальных телефонов: ${phoneBook.keys.toSet().size}""")

    //сумма длинн всех номеров телефонов
    println("""Сумма длинн всех номеров телефонов: ${phoneBook.keys.sumOf { it.length }}""")

    //выводим отсортированное по имени
    println("Сортируем по имени:")
    //println(phoneBook.entries.sortedBy { it.value }.joinToString("\n"))
    for (entry in phoneBook.entries.sortedBy { it.value })
        println("""Абонент: ${entry.value}. Номер телефона: ${entry.key}""")

    //выводим отсортированное по номеру телефона
    println("Сортируем по номеру телефона:")
    //println(phoneBook.entries.sortedBy { it.value }.joinToString("\n"))
    for (entry in phoneBook.entries.sortedBy { it.key })
        println("""Номер телефона: ${entry.key}. Абонент: ${entry.value}""")
}

//создаем список записей
fun createPhoneBookList(n : Int) : Map<String, String> {
    val iList = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val pair : Pair<String, String> = Pair(
            randomPhone(), if (Random.nextBoolean())
                randomNamesMan()
             else
                randomNamesWoman()
        )
        iList[pair.first] = pair.second

        /*      iList = if (Random.nextBoolean()) {
                  iList + Pair(randomPhone(), randomNamesMan())
              } else
                  iList + Pair(randomPhone(), randomNamesWoman())
         */
    }
    return iList
}

//генерируем номер телефона
fun randomPhone() : String {

    return "+" + Random.nextInt(7, 9).toString() +

            Random.nextInt(900, 999).toString() +

            Random.nextInt(100, 999).toString() +

            Random.nextInt(1000, 9999).toString()

}

//генерируем имена
fun randomNamesMan() : String {
    val name = arrayOf("Павел", "Григорий", "Александр", "Михаил", "Дмитрий", "Андрей", "Евгений", "Семён", "Алексей")
    val patronymic = arrayOf("Леонидович", "Владимирович", "Алексеевич", "Анатольевич",
        "Александрович", "Михаилович", "Дмитриевич", "Андреевич")
    return name[Random.nextInt(0, name.lastIndex)] + " " + patronymic[Random.nextInt(0, patronymic.lastIndex)]
}

fun randomNamesWoman() : String {
    val name =
        arrayOf("Анастасия", "Евгения", "Александра", "Дарья", "Анна", "Екатерина", "Елена", "Маргарита", "Любовь")
    val patronymic = arrayOf("Леонидовна", "Владимировна", "Алексеевна", "Анатольевна",
        "Александровна", "Михаиловна", "Дмитриевна", "Андреевна")
    return name[Random.nextInt(0, name.lastIndex)] + " " + patronymic[Random.nextInt(0, patronymic.lastIndex)]
}