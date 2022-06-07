import kotlin.random.Random

object Chance {
    fun Int.isChance() : Boolean {
        return Random.nextInt(0, 101) <= this
    }
}
