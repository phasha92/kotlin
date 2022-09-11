import kotlinx.coroutines.*

fun main() {
    val qqq = Truck.PassengerCar()
    qqq.printProductList()
    runBlocking {
        List(4) { Truck.GazelleCar() }.forEach {
             launch {
                it.printProductList()
                while (true)
                    it.unLoading()
            }
        }
    }
}