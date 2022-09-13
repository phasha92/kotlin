class UnloadingPort {
    val portNumber: Int

    init {
        count++
        portNumber = count
    }

    suspend fun loadingInComposition(truck: Truck) {
        println("Склад $portNumber принимает : ${truck.serialName} ")
        truck.unLoading().forEach {
            when (it) {
                is Food -> Composition.storage[0].push(it)
                is SmallSizedGoods -> Composition.storage[1].push(it)
                is MediumSizedGoods -> Composition.storage[2].push(it)
                is LargeSizedGoods -> Composition.storage[3].push(it)
            }
        }
        println("Порт приема $portNumber освободился")
    }

    companion object {
        private var count = 0
    }
}