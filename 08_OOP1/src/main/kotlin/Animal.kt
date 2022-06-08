import kotlin.random.Random

abstract class Animal: Attack {
    // свойства
    abstract var energy: Int
    abstract var weight: Int
    abstract val maxAge: Int
    abstract val name: String
    abstract val type: String
    private var age = 0
    private val isTooOld: Boolean
        get() = age >= maxAge

    // функции
    abstract fun birthAnimal(): Animal

    // описываем максимум общей логики
    open fun eat() {
        tryIncrementAge()
        weight++
        energy += 3
        println(this)
    }

    open fun move() {
        tryIncrementAge()
        weight--
        energy -= 5
        println(this)
    }

    open fun sleep() {
        energy += 5
        age++
        println(this)
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) {
            age++
            println("возраст увеличен")
        }
    }

    fun viability(): Boolean {
        return if (isTooOld || weight == 0 || energy == 0) {
            println(" $name не жизнеспособен!")
            false
        } else true
    }

    // имена, почему бы и нет :)
    protected fun getRandomName(): String {
        val a = arrayOf("Жирный ", "Усталый ", "Бесподобный ", "Боевой ", "Превосходный ", "Вонючий ", "Эпический ")
        val b = arrayOf("Пикачу ", "Тапок ", "Сектант ", "Маг ", "Бородач ", "Кирилл ")
        val c = arrayOf("Земли", "Яда", "Дьявола", "Света", "Тьмы")
        return a.random() + b.random() + c.random()
    }

    override val damage: Int
        get() = Random.nextInt(1, 6)

    override fun attack(animal: Animal) {
        if (viability()) {
            val damage = this.damage
            animal.energy -= damage
            println("${this.name} атаковал ${animal.name} и нанес $damage урона")
        }
    }

    override fun toString(): String {
        return """
Энергия: $energy
Вес: $weight
Возраст: $age
        """.trimMargin()
    }

    companion object {
        // счетчики
        var bithing = 0
        var dethind = 0
    }
}

