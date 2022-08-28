import kotlinx.coroutines.*
import java.math.BigInteger

object Fibonacci {
    suspend fun take(n: Int): BigInteger {
        return if (n == 0 || n == 1) n.toBigInteger()
        else {
            var f0 = BigInteger.ZERO
            var f1 = BigInteger.ONE
            var fSum = f0
            try {
                withTimeout(5000) {
                    for (i in 2..n) {
                        fSum = f0 + f1
                        f0 = f1
                        f1 = fSum
                        yield()
                    }
                }
            } catch (e: TimeoutCancellationException) {
                println("\n Превышено время ожидания! \n Установлено значение по умолчанию!")
                return (0).toBigInteger()
            }
            return fSum
        }
    }
}