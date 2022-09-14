import kotlinx.coroutines.*
import kotlin.random.Random

sealed class Truck {
    protected abstract val baggage: Baggage<Product>
    abstract val capacity: Int
    abstract val serialName: String
    val baggageSize: Int
        get() = baggage.weightSum

    data class PassengerCar(
        override val capacity: Int = 50,
        override val baggage: Baggage<Product> = createBaggage(capacity),
    ):
        Truck() {
        override val serialName: String

        init {
            count++
            serialName = "Легковой автомобиль №$count"
        }
    }


    data class GazelleCar(
        override val capacity: Int = 150,
        override val baggage: Baggage<Product> = createBaggage(capacity),
    ):
        Truck() {
        override val serialName: String

        init {
            count++
            serialName = "Газель №$count"
        }
    }

    data class FreightCar(
        override val capacity: Int = 300,
        override val baggage: Baggage<Product> = createBaggage(capacity),
    ):
        Truck() {
        override val serialName: String

        init {
            count++
            serialName = "Грузовик №$count"
        }
    }

    fun printProductList() {
        println("\n$serialName")
        baggage.printProductList()
    }

    suspend fun loading(product: Product) {
        println("\n$serialName")
        println("Загружает $product")
        delay(product.loadingTime)
        baggage.push(product)
    }

    suspend fun unLoading(): List<Product> {
        val productList = mutableListOf<Product>()
        while (!baggage.isEmpty) {
            val element = baggage.pop()
            println("\n$serialName")
            println("Выгружает $element")
            productList.add(element)
            delay(element.loadingTime)
        }
        println("*$serialName закончил выгрузку товаров*")
        return productList
    }


    companion object {
        private var count = 0

        fun createTruck(isEmpty: Boolean): Truck {
            return if (isEmpty)
                when (Random.nextBoolean()) {
                    true -> PassengerCar(baggage = Baggage())
                    else -> GazelleCar(baggage = Baggage())
                }
            else
                when ((1..3).random()) {
                    1 -> PassengerCar()
                    2 -> GazelleCar()
                    else -> FreightCar()
                }
        }

        protected fun createBaggage(capacity: Int): Baggage<Product> {
            val newBaggage = Baggage<Product>()
            val randomChoise = (1..4).random()

            fun element(): Product = when (randomChoise) {
                1 -> LargeSizedGoods.createLargeSizedGoods()
                2 -> MediumSizedGoods.createMediumSizedGoods()
                3 -> SmallSizedGoods.createSmallSizedGoods()
                else -> Food.randomFood()
            }
            while (true) {
                val newElement = element()
                if (newElement.weight + newBaggage.weightSum > capacity) break
                newBaggage.push(newElement)
            }
            return newBaggage
        }
    }
}
