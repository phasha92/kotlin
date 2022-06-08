import kotlin.random.Random

class NatureReserve {
    private val animalArray = mutableListOf<Animal>() //список животных
    private val animalsDeth = mutableListOf<Animal>() //список умерших
    fun life() {
        print("Введите количество дней : ")

        val n = checkNumber(readLine()!!)

        repeat(2) { animalArray.add(Dog()) }
        repeat(5) { animalArray.add(Bird()) }
        repeat(3) { animalArray.add(Fish()) }

        for (j in 1..n) {
            println("День: $j")

            for (animal in animalArray.indices) {
                println("\nходит ${animalArray[animal].name} ------------------- $animal\n")
                when (Random.nextInt(0, 5)) {
                    0 -> animalArray[animal].sleep()
                    1 -> animalArray[animal].eat()
                    2 -> animalArray[animal].move()
                    3 -> animalArray.add(animalArray[animal].birthAnimal())
                    4 -> animalArray[animal].attack(animalArray[Random.nextInt(0, animalArray.size)])
                }
                println()

                Thread.sleep(1000)

                //если животное не жизнеспособно - вносим в список
                if (!animalArray[animal].viability()) animalsDeth.add(animalArray[animal])
            }
            println("""
           Животных было: ${animalArray.size}
           Старые животные: ${animalsDeth.size}
           
           """.trimMargin())

            //если список не пуст, то удаляем из массива
            if (animalsDeth.isNotEmpty()) {
                Animal.dethind += animalsDeth.size
                animalArray.removeAll(animalsDeth)
                animalsDeth.clear()
            }
            if (animalArray.isEmpty()) {
                println("Животных не осталось...")
                statistics()
                break
            }
            println("!!!Всего животных осталось ${animalArray.size}\n")
            statistics()
        }
    }

    private fun statistics() {
        println("""
            статистика за период:
             родилось : ${Animal.bithing}
             померло : ${Animal.dethind}
        """.trimIndent())
    }

    private fun checkNumber(value: String): Int {
        val x: Int = value.toIntOrNull() ?: return checkNumber("Введи еще раз: ".input())
        if (x < 1) return checkNumber("Введи еще раз: ".input())
        return x
    }

    private fun String.input(): String {
        print(this)
        return readLine()!!
    }
}
