import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.sync.Mutex

object Composition {
    val mutex = Mutex()

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val unloadingPorts = List(3) { UnloadingPort() }
    private val loadingPorts = List(5) { LoadingPort() }

    val truckIn = mutableListOf<Truck>()
    val truckOut = mutableListOf<Truck>()

    val storage =
        listOf(
            Baggage<Food>(),
            Baggage<SmallSizedGoods>(),
            Baggage<MediumSizedGoods>(),
            Baggage<LargeSizedGoods>()
        )

    private fun printStorageList() {
        println("Остаток на складе: ")
        storage.forEachIndexed { index, baggage ->
            println("\nСклад № ${index.inc()}")
            baggage.printProductList()
        }
    }

    @ExperimentalCoroutinesApi
    suspend fun compositionProcess(trucksIsEmpty: ReceiveChannel<Truck>, trucksIsFool: ReceiveChannel<Truck>) {
        scope.launch {
            val sending = launch {
                loadingPorts.forEach {
                    launchProcessorLoadingPort(it, trucksIsEmpty)
                }
            }
            val admission = launch {
                unloadingPorts.forEach {
                    launchProcessorUnloadingPort(it, trucksIsFool)
                }
            }
            delay(3_600_000)
            printStorageList()
            sending.cancel()
            admission.cancel()
        }.join()
    }

    fun printTrucksInfo() {
        truckIn.let {
            println("\nПрибывший транспорт: ")
            it.forEach { item ->
                println(item.serialName)
            }
        }
        truckOut.let {
            println("\nОтправленный транспорт: ")
            it.forEach { item ->
                println(item.serialName)
            }
        }
    }
}