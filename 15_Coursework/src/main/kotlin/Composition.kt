import kotlinx.coroutines.sync.Mutex

object Composition {
    val mutex = Mutex()
    val storage =
        listOf(
            Baggage<Food>(),
            Baggage<SmallSizedGoods>(),
            Baggage<MediumSizedGoods>(),
            Baggage<LargeSizedGoods>()
        )

    fun printStorageList() {
        println("На складе: ")
        storage.forEachIndexed { index, baggage ->
            println("Склад № ${index.inc()}")
            baggage.printProductList()
        }
    }
}