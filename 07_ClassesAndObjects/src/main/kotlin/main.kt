import kotlin.random.Random

fun main() {
    var n: Int
    do {
        print("Введите количество тестов : ")
        n = readLine()?.toIntOrNull() ?: 0
        if (n <= 0) println("Попробуйте еще раз!")
    } while (n <= 0)

    val tv = TV.create("Xiaomi", "Redmi", 41.0)
    val tvSecond = TV("Samsung" to "opal", 140.5) // для теста вызовем вторичный конструктор
    val listTV = listOf(tv, tvSecond)
    // тесты
    for (i: Int in 1..n) {
        println("\nТЕСТ - > $i :")
        listTV.forEach {
            print(it)
            when (Random.nextInt(1, 8)) {
                // кнопка включения
                1 -> it.powerOnOrOff()

                // кнопка вывода
                2 -> it.printChanels()

                // кнопка выбора канала
                3 -> it.chanelSwitch((0..10).random())

                // кнопка переключения назад
                4 -> it.chanelDawn()

                // кнопка переключения вперед
                5 -> it.chanelUp()

                // кнопка понижения громкости
                6 -> it.volumeDawn((1..25).random())

                // кнопка увеличения громкости
                7 -> it.volumeUp((1..25).random())
            }
            // останавливаем поток на пару секунд
            Thread.sleep(2000)
        }
    }
}