import kotlinx.coroutines.isActive
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.coroutineContext

class LoadingPort {
    val portNumber: Int = ++count
    private val completeStock: Int
        get() = Composition.storage.indexOf(Composition.storage.maxByOrNull { it.size })

    suspend fun unloadingFromComposition(truck: Truck) {
        println("Порт $portNumber отгружает из склада в ${truck.serialName}")
        var flag = false
        var type = completeStock
        while (coroutineContext.isActive) {
            Composition.mutex.withLock {
                if (!Composition.storage[type].isEmpty) {
                    val newElement = Composition.storage[type].pop()
                    if (newElement.weight + truck.baggageSize > truck.capacity) {
                        Composition.storage[type].push(newElement)
                        println("*Транспорт ${truck.serialName} выехал*")
                        println("Порт загрузки $portNumber освободился")
                        flag = true
                        Composition.truckOut.add(truck)
                    }
                    truck.loading(newElement)
                }
                if (truck.baggageSize == 0) type = completeStock
            }
            if (flag) break
        }
    }

    companion object {
        private var count = 0
    }
}