import kotlin.random.Random

class Bird: Animal() {

    override val type = "Bird - "
    override var energy: Int = Random.nextInt(6, 10)
        get() = if (field < 0) 0 else field
    override var weight = Random.nextInt(3, 7)
        get() = if (field < 0) 0 else field
    override val maxAge = 5
    override val name = type + getRandomName()

    init {
        println("Появилась птичка $name")
    }

    override fun eat() {
        if (viability()) {
            println("Птица ($name) ест")
            super.eat()
        }
    }

    override fun move() {
        if (viability()) {
            println("Птица ($name) летит")
            super.move()
        }
    }

    override fun sleep() {
        if (viability()) {
            println("Птица ($name) спит")
            super.sleep()
        }
    }

    override fun birthAnimal(): Bird {
        println("Птица (${name}) дала потомство! ")
        bithing++
        val animal = Bird()
        println("""новое потомство:
        |имя: ${animal.name}
        |энергия: ${animal.energy}
        |вес: ${animal.weight}
    """.trimMargin())
        return animal
    }
}