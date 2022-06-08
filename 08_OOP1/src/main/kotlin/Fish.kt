import kotlin.random.Random

class Fish: Animal() {

    override val type = "Fish - "
    override var energy = Random.nextInt(6, 10)
        get() = if (field < 0) 0 else field
    override var weight = Random.nextInt(3, 7)
        get() = if (field < 0) 0 else field
    override val maxAge = 3
    override val name = type + getRandomName()

    init {
        println("Появилась рыбка $name")
    }

    override fun eat() {
        if (viability()) {
            println("Рыбка ($name) ест")
            super.eat()
        }
    }

    override fun move() {
        if (viability()) {
            println("Рыбка ($name) летит")
            super.move()
        }
    }

    override fun sleep() {
        if (viability()) {
            println("Рыбка ($name) спит")
            super.sleep()
        }
    }

    override fun birthAnimal(): Fish {
        println("Рыбка (${name}) дала потомство! ")
        val animal = Fish()
        bithing++
        println("""новое потомство:
        |имя: ${animal.name}
        |энергия: ${animal.energy}
        |вес: ${animal.weight}
    """.trimMargin())
        return animal
    }
}