import kotlin.random.Random

class NatureReserve {
     val animalArray = mutableListOf<Animal>() //список животных
    private val animalsDeth = mutableListOf<Animal>() //список умерших

    private var bithing = 0 // родилось
    private var dethind = 0 // отьехало

    fun life() {
        var n : Int
        do {
            print("Введите колличество дней : ")
            n = readLine()?.toIntOrNull() ?: 0
            if (n <= 0) println("Попробуйте еще раз!")
        } while (n <= 0)

        animalArray.add(Dog())
        animalArray.add(Dog())

        animalArray.add(Bird())
        animalArray.add(Bird())
        animalArray.add(Bird())
        animalArray.add(Bird())
        animalArray.add(Bird())

        animalArray.add(Fish())
        animalArray.add(Fish())
        animalArray.add(Fish())

        for (j in 1..n) {
            println("День: $j")

            for (animal in animalArray.indices) {
                println("\nходит ${animalArray[animal].name} ------------------- $animal\n")
                when (Random.nextInt(0, 5)) {
                    0 -> animalArray[animal].sleep()
                    1 -> animalArray[animal].eat()
                    2 -> animalArray[animal].move()
                    3 -> {
                        animalArray.add(animalArray[animal].birthAnimal())
                        bithing++
                    }
                    4 -> animalArray[animal].atack(animalArray[Random.nextInt(0, animalArray.size)])
                }
                println()

                Thread.sleep(1000)

                //если животное постарело - вносим в список
                if (!animalArray[animal].viability()) {
                    animalsDeth.add(animalArray[animal])
                    dethind++
                }
            }
            println("""
           Животных было: ${animalArray.size}
           Старые животные: ${animalsDeth.size}
           
           """.trimMargin())
            //если список не пуст, то удаляем из массива
            if (animalsDeth.isNotEmpty()) {
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
             родилось : $bithing
             померло : $dethind
        """.trimIndent())
    }
}
