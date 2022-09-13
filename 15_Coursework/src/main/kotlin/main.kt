import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
suspend fun main() {
    val scope = CoroutineScope(Job() + Dispatchers.Default)
    val unloadingPorts = List(3) { UnloadingPort() }
    val loadingPorts = List(5) { LoadingPort() }

    val job = scope.launch {
        val pro = generator(true)
        val sending = launch {
            loadingPorts.forEach {
                launchProcessor2(it, pro)
            }
        }
        val producer = generator(time = 60000)
        val admission = launch {

            unloadingPorts.forEach {
                launchProcessor(it, producer)
            }
        }
        delay(100000000)
        Composition.printStorageList()
        pro.cancel()
        producer.cancel()
        joinAll(admission, sending)
    }
    job.join()
}

@ExperimentalCoroutinesApi
fun CoroutineScope.generator(isEmpty: Boolean = false, time: Long = 1) = produce {
    while (isActive) {
        send(Truck.createTruck(isEmpty))
        delay(time)
    }
}

fun CoroutineScope.launchProcessor(id: UnloadingPort, channel: ReceiveChannel<Truck>) = launch {
    for (t in channel) {
        t.printProductList()
        println("Разгрузочный порт ${id.portNumber} принял транспорт: ${t.serialName}")
        id.loadingInComposition(t)
    }
}

fun CoroutineScope.launchProcessor2(id: LoadingPort, channel: ReceiveChannel<Truck>) = launch {
    for (t in channel) {
        t.printProductList()
        println("Загрузочный порт ${id.portNumber} принял транспорт: ${t.serialName}")
        id.unloadingFromComposition(t)
    }
}