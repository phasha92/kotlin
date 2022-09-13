class Baggage<T: Product> {
    private val products = mutableListOf<T>()

    val isEmpty: Boolean
        get() = products.isEmpty()

    val size:Int
    get() = products.size

    val sizeSum: Int
        get() = products.sumOf { it.weight }

    fun push(item: Product) = products.add(item as T)

    fun pop(): T = products.removeLast()

    fun printProductList() = products.let {
        if (!isEmpty) {
            println("Список товаров :")
            it.groupingBy { item -> item }.eachCount().map { (k, v) -> "$k : ${v}шт" }.forEach { product ->
                println(product)
            }
        } else println("Багажник пуст")
    }


}