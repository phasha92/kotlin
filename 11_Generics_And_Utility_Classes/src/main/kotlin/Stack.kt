class Stack<T: Ammo> {
    private val stack = mutableListOf<T>()

    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T? {
        return if (isEmpty())
            null
        else {
            val element = stack.last()
            stack.removeAt(stack.lastIndex)
            element
        }
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }
}