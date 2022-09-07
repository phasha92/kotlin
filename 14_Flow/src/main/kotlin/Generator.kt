import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.onEach

object Generator {
    var count = 0
    val flow = (1..90).shuffled().asFlow().onEach {
        delay(1)
        println("Выпал боченок № $it")
        count++
    }
}