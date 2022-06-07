import kotlin.random.Random

abstract class Animal : Atackolable {

    var bithing = 0
    var dethind = 0

    abstract var energy : Int
    abstract var weight : Int
    abstract val maxAge : Int
    abstract val name : String

    open var age = 0

    abstract val type : String

    private fun isTooOld() : Boolean {
        return age >= maxAge
    }

    fun sleep(){
        if (viability()) {
            energy += 5
            age++
            println("$name спит")
            println(toString())
        }
    }

    abstract fun eat()

    abstract fun move()

    abstract fun birthAnimal() : Animal


    protected fun tryIncrementAge() {

        if (Random.nextBoolean()) {
            age++
            println("возраст увеличен")
        }
    }

    open fun viability() : Boolean {
        when {
            isTooOld() -> {
                println(" $name слишком старый!")
                return false
            }
            weight <= 0 -> {
                println(" $name слишком слаб")
                return false
            }
            energy <= 0 -> {
                println(" У $name закончилась энергия")

                return false
            }
            else -> return true
        }
    }

    fun getRandomName() : String {
        val a = arrayOf("Жирный ", "Усталый ", "Бесподобный ", "Боевой ", "Превосходный ", "Вонючий ","Эпический ")
        val b = arrayOf("Пикачу ", "Тапок ", "Сектант ", "Маг ", "Бородач ", "Кирилл ")
        val c = arrayOf("Земли", "Яда", "Дьявола", "Света", "Тьмы")
        return (a[Random.nextInt(0, a.size)] + b[Random.nextInt(0, b.size)] + c[Random.nextInt(0, c.size)])
    }

    override val damage : Int
        get() = Random.nextInt(0, 5)

    override fun atack(animal : Animal) {
        if (viability()) {
            val damage = this.damage
            animal.energy -= damage
            println("$name атаковал ${animal.name} и нанес $damage урона")
        }
    }

    override fun toString() : String {
        return """
Энергия: $energy
Вес: $weight
Возраст: $age
        """.trimMargin()
    }
}

