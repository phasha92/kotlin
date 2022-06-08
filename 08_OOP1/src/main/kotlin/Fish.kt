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
        if (viability()) super.eat().run { println("Рыбка ($name) ест") }
    }

    override fun move() {
        if (viability()) super.move().run { println("Рыбка ($name) летит") }
    }

    override fun sleep() {
        if (viability()) super.sleep().run { println("Рыбка ($name) спит") }
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