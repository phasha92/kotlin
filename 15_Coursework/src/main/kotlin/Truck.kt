import kotlinx.coroutines.delay

sealed class Truck {
    protected abstract val baggage: Baggage<Product>
    protected abstract val capacity: Int
    abstract val serialName: String

    data class PassengerCar(override val capacity: Int = 50, override val baggage: Baggage<Product> = Baggage()):
        Truck() {
        override val serialName: String = "Легковой автомобиль №$count"

        init {
            createBaggage(capacity)
        }
    }

    data class GazelleCar(override val capacity: Int = 150, override val baggage: Baggage<Product> = Baggage()):
        Truck() {
        override val serialName: String = "Газель №$count"

        init {
            createBaggage(capacity)
        }
    }

    data class FreightCar(override val capacity: Int = 300, override val baggage: Baggage<Product> = Baggage()):
        Truck() {
        override val serialName: String = "Грузовик №$count"

        init {
            createBaggage(capacity)
        }
    }

    fun printProductList() {
        println("\n$serialName")
        baggage.printProductList()
    }

    suspend fun loading(product: Product) {
        delay(product.loadingTime)
        baggage.push(product)

    }

    suspend fun unLoading(): List<Product> {
        val productList = mutableListOf<Product>()

        while (!baggage.isEmpty) {
            val element = baggage.pop()
            println("\n$serialName")
            println("Выгрузка $element")
            productList.add(element)
            delay(element.loadingTime)
        }
        println("*$serialName закончил выгрузку товаров*")
        return productList
    }

    protected fun createBaggage(capacity: Int) {

        val randomChoise = (1..4).random()
        fun element(): Product = when (randomChoise) {
            1 -> LargeSizedGoods.createLargeSizedGoods()
            2 -> MediumSizedGoods.createMediumSizedGoods()
            3 -> SmallSizedGoods.createSmallSizedGoods()
            else -> Food.randomFood()
        }
        
        while (true) {
            val newElement = element()
            if (newElement.weight + baggage.size > capacity) break
            baggage.push(newElement)
        }
        count++
    }

    companion object {
        private var count = 1
        fun createTruck() = when ((1..3).random()) {
            1 -> PassengerCar()
            2 -> GazelleCar()
            else -> FreightCar()
        }
    }

}
