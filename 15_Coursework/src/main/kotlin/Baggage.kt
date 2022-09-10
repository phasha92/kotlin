class Baggage<T: Product> {
    private val products = mutableListOf<T>()

    val isEmpty: Boolean
        get() = products.isEmpty()

    fun push(item: T) {
        products.add(item)
    }

    fun pop(): T? {
        if (products.isNotEmpty()) {
            val element = products.last()
            products.removeAt(products.lastIndex)
            return element
        }
        return null
    }

    fun printProductList() = products.let {
        if (!isEmpty) {
            println("Список продуктов:")
            it.groupingBy { item -> item }.eachCount().map { (k, v) -> "$k : ${v}шт" }.forEach { product ->
                println(product)
            }
        } else println("Багажник пуст")
    }
}