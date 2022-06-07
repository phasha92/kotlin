import Fibonacci.take
import kotlinx.coroutines.*

fun main() {

    runBlocking {

        val job1 = async { take(2110600) }
        val job2 = async { take(300) }
        val job3 = async { take(100) }

        val progress = launch {
            while (job1.isActive || job2.isActive || job3.isActive) {
                progress()
            }
        }
        awaitAll(job1,job2,job3).forEach { println(it) }
        progress.cancelAndJoin()
    }
}

suspend fun progress() {
    yield()
    delay(100)
    print(".")

}
