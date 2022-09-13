import kotlinx.coroutines.*
import kotlinx.coroutines.sync.withLock

class LoadingPort {
    val portNumber: Int
    private val completeStock: Int
        get() = Composition.storage.indexOf(Composition.storage.maxByOrNull { it.size })

    init {
        count++
        portNumber = count
    }

    suspend fun unloadingFromComposition(truck: Truck) {
        println("Порт $portNumber отгружает из склада в ${truck.serialName}")
        Composition.mutex.withLock {
            val type = completeStock
            while (true) {
                yield()
                if (!Composition.storage[type].isEmpty) {
                    val newElement = Composition.storage[type].pop()
                    if (newElement.weight + truck.baggageSize > truck.capacity) {
                        Composition.storage[type].push(newElement)
                        break
                    }
                    truck.loading(newElement)
                }
            }
        }
        println("*Транспорт ${truck.serialName} выехал*")
        truck.printProductList()
        println("Порт загрузки $portNumber освободился")
    }

    companion object {
        private var count = 0
    }
}