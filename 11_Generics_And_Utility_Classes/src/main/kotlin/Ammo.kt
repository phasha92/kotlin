import Chance.isChance

enum class Ammo(
    private val damage : Int,
    private val chanceCrit : Int,
    private val coeffCrit : Int,
) {
    SMALL(5, 15, 2),
    MEDIUM(10, 20, 2),
    HARD(15, 30, 3),
    ULTIMATE(20, 50, 4);

    fun getDamage() : Int {
        val crit : Int
        return if (chanceCrit.isChance()) {
            crit = damage * coeffCrit
            print(" CRIT! $crit \n")
            crit
        } else {
            println(" $damage")
            damage
        }
    }

}


