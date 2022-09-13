import kotlinx.coroutines.yield

class LoadingPort {
    val portNumber: Int

    init {
        count++
        portNumber = count
    }

    suspend fun unloadingFromComposition(truck: Truck) {
        println("Склад $portNumber отгружает в ${truck.serialName}")
        val type = (0..3).random()
        while (true) {     // ожидаем загрузку определенного типа товара до тех пор, пока не влезет
            yield()
            if (!Composition.storage[type].isEmpty) {
                val newElement = Composition.storage[type].pop()
                if (newElement.weight + truck.baggageSize > truck.capacity) {
                    Composition.storage[type].push(newElement) // если не влезло, то возвращаем товар назад
                    break                                      // и желаем доброго пути)
                }
                truck.loading(newElement)
            }
        }
        println("Порт загрузки $portNumber освободился")
    }

    companion object {
        private var count = 0
    }
}