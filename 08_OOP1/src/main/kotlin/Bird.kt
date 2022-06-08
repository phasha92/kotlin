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
        if (viability()) super.eat().run { println("Птица ($name) ест") }
    }

    override fun move() {
        if (viability()) super.move().run { println("Птица ($name) летит") }
    }

    override fun sleep() {
        if (viability()) super.sleep().run { println("Птица ($name) спит") }
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