import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce

@ExperimentalCoroutinesApi
fun main() {
    runBlocking {
        val producer = generator()
        repeat(5) { launchProcessor(it, producer) }
        delay(555500)
        producer.cancel()
    }
}

@ExperimentalCoroutinesApi
fun CoroutineScope.generator() = produce {
    while (isActive) {
        send(Truck.createTruck())
        delay(6000)
    }
}

fun CoroutineScope.launchProcessor(id: Int, channel: ReceiveChannel<Truck>) = launch {
    for (t in channel) {
        t.printProductList()
        println("processor $id received ${t.serialName}")
        t.unLoading()
    }
}