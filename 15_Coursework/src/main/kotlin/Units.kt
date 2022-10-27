import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
fun CoroutineScope.generator(isEmpty: Boolean = false, time: Long = 1) = produce {
    while (isActive) {
        send(Truck.createTruck(isEmpty))
        delay(time)
    }
}

fun CoroutineScope.launchProcessorUnloadingPort(id: UnloadingPort, channel: ReceiveChannel<Truck>) = launch {
    for (t in channel) {
        t.printProductList()
        println("Разгрузочный порт ${id.portNumber} принял транспорт: ${t.serialName}")
        id.loadingInComposition(t)
    }
}

fun CoroutineScope.launchProcessorLoadingPort(id: LoadingPort, channel: ReceiveChannel<Truck>) = launch {
    for (t in channel) {
        t.printProductList()
        println("Загрузочный порт ${id.portNumber} принял транспорт: ${t.serialName}")
        id.unloadingFromComposition(t)
    }
}