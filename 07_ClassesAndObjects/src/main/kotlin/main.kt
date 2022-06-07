import kotlin.random.Random

fun main() {

    var n : Int

    do {
        print("Введите колличество тестов : ")
        n = readLine()?.toIntOrNull() ?: 0

        if (n <= 0) println("Попробуйте еще раз!")

    } while (n <= 0)


    val tv = TV("Panasonic" to "ma32", 106.0)

    val tvSecond = TV("Samsung" to "opal", 140.5)

    for (i : Int in 1..n) {
        println("\nТЕСТ - > $i :")

        when (Random.nextInt(1, 8)) {

            1 -> {
                printInfo(tv)
                tv.powerOnOrOff()
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.powerOnOrOff()
                Thread.sleep(2000)
            }
            2 -> {
                printInfo(tv)
                tv.printChanels()
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.printChanels()
                Thread.sleep(2000)
            }
            3 -> {
                printInfo(tv)
                tv.chanelSwitch(Random.nextInt(0, 10))
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.chanelSwitch(Random.nextInt(0, 10))
                Thread.sleep(2000)
            }
            4 -> {
                printInfo(tv)
                tv.volumeDawn(Random.nextInt(0, 25))
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.volumeDawn(Random.nextInt(0, 25))
                Thread.sleep(2000)
            }
            5 -> {
                printInfo(tv)
                tv.volumeUp(Random.nextInt(0, 25))
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.volumeUp(Random.nextInt(0, 25))
                Thread.sleep(2000)
            }
            6 -> {
                printInfo(tv)
                tv.chanelUp()
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.chanelUp()
                Thread.sleep(2000)
            }
            7 -> {
                printInfo(tv)
                tv.chanelDawn()
                Thread.sleep(2000)

                printInfo(tvSecond)
                tvSecond.chanelDawn()
                Thread.sleep(2000)
            }
        }

    }
}

fun printInfo(tv : TV) {
    println("\n${tv.brandArg} ${tv.modelArg} с диагональю: ${tv.diagonalArg} ")
}

