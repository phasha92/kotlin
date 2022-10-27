import kotlinx.coroutines.*

@ExperimentalCoroutinesApi
suspend fun main() {
    Composition.scope.launch {
        val trucksIsEmpty = generator(true)
        val trucksIsFool = generator(time = 60_000)
        Composition.compositionProcess(trucksIsEmpty, trucksIsFool)
        trucksIsEmpty.cancel()
        trucksIsFool.cancel()
    }.join()
    Composition.printTrucksInfo()
}