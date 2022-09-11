class Baggage<T: Product> {
    private val products = mutableListOf<T>()

    val isEmpty: Boolean
        get() = products.isEmpty()

    fun push(item: T) = products.add(item)

    fun pop(): T = products.removeLast()

    fun printProductList() = products.let {
        if (!isEmpty) {
            println("Список продуктов:")
            it.groupingBy { item -> item }.eachCount().map { (k, v) -> "$k : ${v}шт" }.forEach { product ->
                println(product)
            }
        } else println("Багажник пуст")
    }
}