import kotlin.random.Random

class Fish: Animal() {

    override val type = "Fish - "

    override var energy = Random.nextInt(3,6)
    override var weight = Random.nextInt(3,7)
    override val maxAge = 5
    override val name = type + getRandomName()

    override var age = 0

    init {
        println("новый $name объект создан")
    }

    override fun eat() {

        if (viability()) {
            energy += 3
            println("Рыба ($name) ест")
            tryIncrementAge()
            weight++
            println("Энергия: $energy")
            println("Вес: $weight")
            println("Возраст: $age")

        }
    }

    override fun move() {
        if (viability()) {
            energy -= 5
            weight--
            println("Рыба ($name) плывет")
            tryIncrementAge()
            println("Энергия: $energy")
            println("Вес: $weight")
            println("Возраст: $age")
        }
    }

    override fun birthAnimal() : Fish {
        val animal = Fish()
        bithing++
        println("Рыба  (${name}) дала потомство! ")
        println("""новое потомство:
        |имя: ${animal.name}
        |энергия: ${animal.energy}
        |вес: ${animal.weight}
    """.trimMargin())
        return animal
    }

}