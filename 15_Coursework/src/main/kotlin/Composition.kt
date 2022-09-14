import kotlinx.coroutines.sync.Mutex

object Composition {
    val mutex = Mutex()

    val truckIn = mutableListOf<Truck>()
    val truckOut = mutableListOf<Truck>()

    val storage =
        listOf(
            Baggage<Food>(),
            Baggage<SmallSizedGoods>(),
            Baggage<MediumSizedGoods>(),
            Baggage<LargeSizedGoods>()
        )

    fun printStorageList() {
        println("Остаток на складе: ")
        storage.forEachIndexed { index, baggage ->
            println("\nСклад № ${index.inc()}")
            baggage.printProductList()
        }
    }

}