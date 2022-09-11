fun main() {
    val t = Baggage<Product>()
    val ggg = Truck.PassengerCar()
    println(t.isEmpty)
    t.push(Food.randomFood())
    t.push(Food.randomFood())
    t.push(Food.randomFood())
    t.push(Food.randomFood())
    t.push(Food.randomFood())
    t.push(Food.randomFood())
    t.printProductList()
    while (!t.isEmpty){
        t.pop().let {
            println("\nвыгружаем $it")
            Thread.sleep(it.loadingTime)
            ggg.baggage.push(it)
        }
        t.printProductList()
    }
    println("ggg")
    ggg.baggage.printProductList()
    ggg.capacity
}