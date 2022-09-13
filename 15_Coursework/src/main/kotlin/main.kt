import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
suspend fun main() {
    val scope = CoroutineScope(Job() + Dispatchers.Default)
    val a = List(3) { UnloadingPort() }
    val b = List(5) { LoadingPort() }
    val job = scope.launch {

        val producer = generator(time = 6000)
        a.forEach {
            launchProcessor(it, producer)
        }
        val pro = generator(true)
        b.forEach {
            launchProcessor2(it,pro)
        }
        delay(100000000)
        Composition.printStorageList()
        producer.cancel()
    }
    job.join()
}

@ExperimentalCoroutinesApi
fun CoroutineScope.generator(isEmpty: Boolean = false, time:Long=1) = produce {
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